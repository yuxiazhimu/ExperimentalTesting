package com.sfs.experimentaltesting.controller;

import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static jodd.util.ThreadUtil.sleep;

@RestController
public class TestAop {
    @GetMapping("/textAop")
    public void textAop(){
        sleep(100);
        throw new RuntimeException("111");
    }
}
