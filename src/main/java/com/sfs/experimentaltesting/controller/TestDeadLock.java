package com.sfs.experimentaltesting.controller;

import com.sfs.experimentaltesting.domin.DeadLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

import static jodd.util.ThreadUtil.sleep;

@RestController
public class TestDeadLock {
    @GetMapping("/testDeadLock1")
    public Integer testDeadLock1(){
        DeadLock.lock1.lock();
        sleep(5000);
        DeadLock.lock2.lock();
        DeadLock.lock2.unlock();
        DeadLock.lock1.unlock();
        return 2;
    }

    @GetMapping("/testDeadLock")
    public Integer testDeadLock2(){
        DeadLock.lock2.lock();
        sleep(5000);
        DeadLock.lock1.lock();
        DeadLock.lock1.unlock();
        DeadLock.lock2.unlock();
        return 1;
    }
}
