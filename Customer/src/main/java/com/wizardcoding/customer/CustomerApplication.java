package com.wizardcoding.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.openfeign.EnableFeignClients;

// This annotation indicates that this class is the main class of a Spring Boot application
@SpringBootApplication
@EnableFeignClients
public class CustomerApplication {
    // The entry point of the application, where execution start
    public static void main(String[] args) {
        // This line initiates the Spring Boot application, passing the current class and command line arguments
        SpringApplication.run(CustomerApplication.class,args);
    }


}