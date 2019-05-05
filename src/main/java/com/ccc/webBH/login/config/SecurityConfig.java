package com.ccc.webBH.login.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailimpl  userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("kai").password("123").roles("CUSTOMMER");
		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/product").hasRole("CUSTOMMER");

		http.authorizeRequests().antMatchers("/Login").permitAll();

		http.formLogin().loginPage("/Login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/product")
		.failureUrl("/Login")
		.usernameParameter("username")
		.passwordParameter("password")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/Login");
		
	}

}
