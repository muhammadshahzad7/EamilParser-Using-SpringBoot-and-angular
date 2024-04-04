package com.example.Backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {
@Bean
    CommandLineRunner commandLineRunner(EmailRepository repository){
    return args -> {

    };
}
}
