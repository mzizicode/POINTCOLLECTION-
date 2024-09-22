package com.wizardcoding.amqp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class ProductConfig {

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }
}
