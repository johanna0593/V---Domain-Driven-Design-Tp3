package com.petfriends.petfriends_tp3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();

        // Allow H2 console frames
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }
}
