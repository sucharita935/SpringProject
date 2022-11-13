package com.eazyBank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BankSecurityConfiguration {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().requestMatchers("/myAccount","/myBalance","/myLoans"
		 * ,"/myCards").authenticated().and().formLogin() .and().httpBasic();
		 */
		return http.authorizeHttpRequests().antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
				.authenticated().antMatchers("/notices", "/contact").permitAll().and().formLogin().and().build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withUsername("admin").password("admin12345").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("user12345").authorities("read").build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
