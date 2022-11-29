package com.zou;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableEncryptableProperties
public class Springboot2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2DemoApplication.class, args);
    }

}
