package com.sfs.experimentaltesting.domin;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

@Data
@Component
public class DeadLock {
    public final static ReentrantLock lock1=new ReentrantLock();
    public final static ReentrantLock lock2=new ReentrantLock();
}
