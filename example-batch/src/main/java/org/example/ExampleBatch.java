package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = { ExampleBatch.class, ExampleCore.class })
public class ExampleBatch {
    public static void main(String[] args) {
        SpringApplication.run(ExampleBatch.class, args);
    }
}
