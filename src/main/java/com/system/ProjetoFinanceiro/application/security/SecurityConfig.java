//package com.system.ProjetoFinanceiro.application.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // 1. Permite o acesso total à URL do console do H2
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                // 2. Corrige o problema do console do H2 ficar em branco/cinza após logar
//                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
//                // 3. Desabilita a proteção CSRF especificamente para a rota do H2
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
//
//        return http.build();
//    }
//}
