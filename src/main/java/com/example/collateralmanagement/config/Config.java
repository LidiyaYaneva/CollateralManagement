package com.example.collateralmanagement.config;

import com.example.collateralmanagement.models.enums.UserRole;
import com.example.collateralmanagement.repositories.UserRepository;
import com.example.collateralmanagement.services.impl.authenticationServices.ApplicationUserDetailsServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Configuration
public class Config {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Scanner createScanner(){
        return new Scanner(System.in);
    }

    @Bean
    public Gson createGson(){
        return new GsonBuilder().create();
    }

    @Bean
    public ModelMapper createModelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.addConverter(mappingContext ->
                        LocalDate.parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                String.class,
                LocalDate.class);

        return modelMapper;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/adminPanel").hasRole(UserRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/");

//        .antMatchers('/').permitAll()
//                .anyRequest().authenticated();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsServiceImpl(userRepository);
    }
}
