package com.appjam.aeteut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AeteutApplication {

    public static void main(String[] args) {
        SpringApplication.run(AeteutApplication.class, args);
    }

}
