//package com.retail.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication()
//		.withUser("user").password("{noop}userpassword").roles("USER")
//		.and()
//		.withUser("admin").password("{noop}adminpassword").roles("USER", "ADMIN");
//
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.httpBasic()
//		.and()
//		.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/retail/**").hasRole("USER")
//		.antMatchers(HttpMethod.POST, "/retail").hasRole("ADMIN")
//		.antMatchers(HttpMethod.PUT, "/retail/**").hasRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE, "/retail/**").hasRole("ADMIN")
//		.and()
//		.csrf().disable()
//		.formLogin().disable();
//	}
//}