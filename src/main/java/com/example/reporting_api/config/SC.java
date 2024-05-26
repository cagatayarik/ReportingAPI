//package com.example.reporting_api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/public/**").permitAll() // Herkese açık endpoint'ler
//                        .anyRequest().authenticated() // Diğer tüm endpoint'ler kimlik doğrulama gerektirir
//                )
//                .addFilterBefore(new JwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // JWT Token doğrulama filtresi ekleniyor
//
//
//        return http.build();
//    }
//}
