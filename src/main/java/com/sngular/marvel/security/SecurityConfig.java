package com.sngular.marvel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public UserDetailsService userDetailsService() {
        // Configuración de usuarios en memoria (puedes personalizar según tus necesidades)
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }
	
	@Configuration
    public static class WebSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();
    		http.cors();
    		
            http
                .authorizeRequests()
                    .antMatchers("/api/marvel/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .and()
                .httpBasic();
        }
    }

}
