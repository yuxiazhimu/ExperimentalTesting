package com.sfs.experimentaltesting.config;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class AopConfig {
    @Before("execution(* com.sfs.experimentaltesting.controller.*.*(..))")
    public void logInfo(){
        System.out.println("打印了");
    }
}
