package com.devlog.piano.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    public SecurityConfig(SecurityUserDetailsService securityUserDetailsService) {
        this.securityUserDetailsService = securityUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.authorizeRequests((authz) -> {
            authz.antMatchers("/", "/about/**", "/contact/**", "/guestBoard/**", "/gallery/**", "/system/**").permitAll();
            authz.antMatchers("/board/**").authenticated();
            authz.antMatchers("/admin/**").hasRole("ADMIN");
        });

        security.csrf().disable();

        security.formLogin()
                .loginPage("/system/login")
                .defaultSuccessUrl("/board/list", true);

        security.exceptionHandling()
                .accessDeniedPage("/system/accessDenied");

        security.logout()
                .logoutUrl("/system/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/");

        return security.build();
    }
}
