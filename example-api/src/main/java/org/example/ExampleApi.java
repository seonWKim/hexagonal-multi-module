package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ExampleApi.class, ExampleCore.class})
public class ExampleApi {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApi.class, args);
    }
}
