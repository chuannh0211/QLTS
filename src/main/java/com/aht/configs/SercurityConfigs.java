package com.aht.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SercurityConfigs extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				.antMatchers("/js/**",
                        "/css/**",
						/* "/img/**", */
                        "/images/**",
                        "/webjars/**",
                        "/fonts/**",
                        "/scss/**",
                        "/node_modules/**",
                        "/bower_components/**","/login","/register-form").permitAll()
				.antMatchers("/user/**", "/group/**").hasAnyRole("ADM", "MANAGER")
				.antMatchers("/supplier/**").hasRole("ADM")
				.antMatchers("/users/**").hasRole("USER")
				.anyRequest()
				.authenticated()
				.and().csrf().disable()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("uname").passwordParameter("pw")
				.defaultSuccessUrl("/")
				.failureUrl("/")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID")
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}
}
