package com.ccc.webBH.login.config;



import java.util.Collections;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
@EnableWebSecurity
@EnableWebMvc
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
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.port", "587");
		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("nvmc1997@gmail.com");
		mailSender.setPassword("cuongvip");

		return mailSender;
	}
	
	
	@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }
	
	@Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver 
          = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine());
	    return viewResolver;
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
		.defaultSuccessUrl("/")
		.failureUrl("/LoginError")
		.usernameParameter("username1")
		.passwordParameter("password1")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/");
		
	}

}
