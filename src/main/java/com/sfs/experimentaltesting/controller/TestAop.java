package com.sfs.experimentaltesting.controller;


import com.sfs.experimentaltesting.annotate.MyAnnotate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static jodd.util.ThreadUtil.sleep;

@RestController
@Slf4j
public class TestAop {
    @GetMapping("/textAop")
    @MyAnnotate
    public void textAop(){
        log.info("打后面");
    }
}
