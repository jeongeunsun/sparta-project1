package com.twopro.deliveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DeliveryappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryappApplication.class, args);
    }

}
