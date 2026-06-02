package com.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLibraryManagementSystem1Application {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringBootLibraryManagementSystem1Application.class,
                args
        );
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("Project started successfully");
        };
    }
}