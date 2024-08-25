package com.sfs.experimentaltesting.excption;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    public String runException(){
        log.info("出问题了");
        return "出问题了";
    }
}
