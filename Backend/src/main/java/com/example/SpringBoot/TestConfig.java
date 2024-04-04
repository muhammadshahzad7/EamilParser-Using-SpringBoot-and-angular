package com.example.SpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class TestConfig {
    @Bean
    CommandLineRunner commandLineRunner(TestRepository repository){
        return args -> {
            TestClass Shezi= new TestClass(
                    "Shezi",
                    "Shezi@gmail.com",
                    LocalDate.of(2002, Month.JANUARY, 5)

            );
            TestClass farhan= new TestClass(
                    "farhan",
                    "farhan@gmail.com",
                    LocalDate.of(2000,Month.JANUARY,5)

            );
            TestClass Ali= new TestClass(
                    "Ali",
                    "ALi@gmail.com",
                    LocalDate.of(1990,Month.JANUARY,5)
            );
            repository.saveAll(
                    List.of(Shezi,Ali,farhan)
            );

        };
    }
}
