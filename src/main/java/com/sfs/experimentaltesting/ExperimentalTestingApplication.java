package com.sfs.experimentaltesting;

import lombok.Synchronized;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@SpringBootApplication
public class ExperimentalTestingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExperimentalTestingApplication.class, args);
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
    }

}
