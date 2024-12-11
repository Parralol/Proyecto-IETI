package com.proyecto.ieti.pemc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.ieti.pemc.config.CustomCorsConfiguration;
import com.proyecto.ieti.pemc.service.CustomUserDetailsService;

@SuppressWarnings("unused")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomCorsConfiguration customCorsConfiguration;

    @Bean
    WebSecurityCustomizer configureWebSecurity() {
        return (web) -> web.ignoring().requestMatchers("/resources/**", "/static/**", "/static/css/**", "/static/js/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST, "/v1/authenticate/").permitAll()
                        .requestMatchers("/", "/login", "/public/**", "/static/**", "/resources/**", "/static/**", "/static/css/**",
                         "/static/js/**", "/index.html", "/manifest.json", "/logo192.png"
                         , "/favicon.ico")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/users/", "/api/chat").authenticated()
                        .requestMatchers(HttpMethod.GET, "/v1/users/", "/api/chat").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/v1/users/{id}", "/api/chat").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/v1/users/{id}", "/api/chat").authenticated()
                        .anyRequest().authenticated())
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/login") // Redirect to login page on access denied
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(c -> c.configurationSource(customCorsConfiguration));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
