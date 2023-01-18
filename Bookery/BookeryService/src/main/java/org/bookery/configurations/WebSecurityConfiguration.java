package org.bookery.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfiguration 
{

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
	http
		.httpBasic()
		.and()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
		.requestMatchers(HttpMethod.POST, "/api").hasRole("ROLE_ADMINISTRATOR")
		.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMINISTRATOR")
		.anyRequest().authenticated()
		.and()
		.csrf().disable();
	
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}

