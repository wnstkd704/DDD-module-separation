package com.dddmoduleseparation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class dddModuleSeparationApplication {

    public static void main(String[] args) {
        SpringApplication.run(dddModuleSeparationApplication.class, args);
    }

}
