package com.Website.BulkTech.Config;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
       @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetails(PasswordEncoder encoder) {

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("5678"))
                .roles("ADMIN")
                .build();

        UserDetails trainer = User.builder()
                .username("trainer")
                .password(encoder.encode("2468"))
                .roles("TRAINER")
                .build();

        return new InMemoryUserDetailsManager(user, admin, trainer);

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/logins/**","/index","/assets/**","/templates/**","/new-user","/memberlogin","/workout/**","/postLogin").permitAll()
                        .requestMatchers("/postLogin").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/logins")            // GET
                        .loginProcessingUrl("/logins")   // POST
                        .defaultSuccessUrl("/postLogin", true) //moves to postLogin Controller
                        .failureUrl("/logins?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/logins?logout=true")
                );

        return http.build();
    }


}