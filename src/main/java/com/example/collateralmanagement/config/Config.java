package com.example.collateralmanagement.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Configuration
public class Config {

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

        modelMapper.addConverter(mappingContext ->
                        LocalDate.parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                String.class,
                LocalDate.class);

        return modelMapper;
    }
}
