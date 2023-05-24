package com.telusko.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

//	    @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService);
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	            .antMatchers("/admin/**").hasRole("ADMIN")
//	            .antMatchers("/user/**").hasRole("USER")
//	            .and()
//	            .formLogin()
//	            .and()
//	            .logout().logoutSuccessUrl("/login").permitAll();
//	    }

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
