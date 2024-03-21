package com.example.guru_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GuruServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuruServicesApplication.class, args);
    }

}
