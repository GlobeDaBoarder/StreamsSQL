package com.example.streamssql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StreamsSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamsSqlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

        };
    }

}
