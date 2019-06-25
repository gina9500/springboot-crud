package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Springboot5CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot5CrudApplication.class, args);
    }

}
