package org.taskmanagementsystem.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
}
