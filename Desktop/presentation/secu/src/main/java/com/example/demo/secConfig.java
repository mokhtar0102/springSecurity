package com.example.demo;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //anotation qui permet de scanner cette classe parmi les premier dans le demarage
@EnableWebSecurity //permet de definer les utilisateur qui ont le droit
@EnableGlobalMethodSecurity(securedEnabled = true) // stratigie de spring securite permet de securise les methode dans le service
public class secConfig extends WebSecurityConfigurerAdapter {
 
	
	@Autowired
	public void golbalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
	/*
	 auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN","PROF");
 	 auth.inMemoryAuthentication().withUser("prof1").password("{noop}123").roles("PROF");
	 auth.inMemoryAuthentication().withUser("etud1").password("{noop}123").roles("ETUDIANT");
	 auth.inMemoryAuthentication().withUser("scolar").password("{noop}123").roles("SCOLARITE");
*/
	 auth.jdbcAuthentication()
	 	.dataSource(dataSource)
        .passwordEncoder(passwordEncoder())
	 	.usersByUsernameQuery("select username as principal, password as credentials, true from user  where username = ?")
 	 	.authoritiesByUsernameQuery("select user_username as principal,roles_role as role from users_roles where user_username = ?")
	 	.rolePrefix("ROLE_");
       }
	
	
	
 @Bean
 public PasswordEncoder passwordEncoder(){
     PasswordEncoder encoder = new BCryptPasswordEncoder();
     return encoder;}
 
 
 @Override
	protected void configure(HttpSecurity http) throws Exception {
	 http
	 	.authorizeRequests()
	 		.antMatchers("/css/**","/js/**","/image/**").permitAll()
	 		.anyRequest()
	 			.authenticated()
	 				.and()
	 					.formLogin()
	 						.loginPage("/login") //redirect lel page edhika
	 						.permitAll()
	 						.defaultSuccessUrl("/index.html");
	}
 //proteger toutes les resouces
}
