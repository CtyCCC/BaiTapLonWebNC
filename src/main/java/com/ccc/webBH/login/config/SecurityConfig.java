package com.ccc.webBH.login.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.ccc.webBH.login.dao")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    driverManagerDataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=WEBBANXEHOI");
	    driverManagerDataSource.setUsername("sa");
	    driverManagerDataSource.setPassword("1");
	    return driverManagerDataSource;
	}

	@Autowired
	UserDetailimpl  userDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
			auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		
		//Ai cũng dùng đc
		http.authorizeRequests().antMatchers("/Login","/product","/phukien","/product-detail","/cart").permitAll();
		
		//Chỉ ADM và CUS dùng đc
		//http.authorizeRequests().antMatchers("/addCart").hasAnyRole("ADMIN","CUSTOMMER");
		
		//Chỉ có ADM dùng đc
		http.authorizeRequests().antMatchers("/productMgmt","/orderMgmt","/userMgmt").hasRole("ADMIN").and();

		

		http.formLogin().loginPage("/Login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/product")
		.failureUrl("/Login")
		.usernameParameter("username")
		.passwordParameter("password")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/product");
		
	}

}
