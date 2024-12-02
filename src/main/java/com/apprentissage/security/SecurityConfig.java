package com.apprentissage.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder)
{
    String encodedpassword = passwordEncoder.encode("1234");
    return new InMemoryUserDetailsManager(
            User.withUsername("user1").password(encodedpassword).roles("USER").build(),
            User.withUsername("user2").password(encodedpassword).roles("USER").build(),
            User.withUsername("admin").password(encodedpassword).roles("USER","ADMIN").build()
    );
}

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
 return httpSecurity
         .formLogin(Customizer.withDefaults())
         .authorizeHttpRequests(ar->ar.requestMatchers("/deletePatient").hasRole("ADMIN"))
         .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
         .build();
}
}
