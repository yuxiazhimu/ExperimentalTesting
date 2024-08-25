package com.sfs.experimentaltesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExperimentalTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentalTestingApplication.class, args);
    }

}
