package com.sfs.experimentaltesting.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAnnotationAspect {

    @Pointcut("@annotation(com.sfs.experimentaltesting.annotate.MyAnnotate)")
    public void cutMethod(){}

    @Before("cutMethod()")
    public void before(JoinPoint joinPoint){
        log.info("这是注解打的哦");
    }
}
