package org.taskmanagementsystem.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * AuthService depends on PasswordEncoder, but no bean was ever defined for it
     * anywhere in the app. Spring Security does not auto-provide one, so the
     * application context failed to start with a NoSuchBeanDefinitionException
     * (surfaced in tests as "Failed to load ApplicationContext").
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth-> auth
                                .requestMatchers("/api/auth/**").permitAll()
                                .anyRequest().authenticated()
                        );
        return http.build();
    }
}
