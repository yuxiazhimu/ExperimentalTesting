package com.sfs.experimentaltesting.testThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OrderLockOfCondition {
    public final ReentrantLock lock = new ReentrantLock();
    public final Condition[] conditions = new Condition[3];

    public char[] c=new char[]{'a','b','c'};
    public volatile int cur;

    public void creatCondition() {
        for (int i = 0; i < 3; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public static void main(String[] args) {
        OrderLockOfCondition orderLockOfCondition = new OrderLockOfCondition();
        orderLockOfCondition.creatCondition();
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                while (true) {
                    orderLockOfCondition.lock.lock();
                    try{
                        while (orderLockOfCondition.cur % 3 != threadId) {
                            try {
                                orderLockOfCondition.conditions[threadId].await();
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                        System.out.print(orderLockOfCondition.c[orderLockOfCondition.cur%3]);
                        orderLockOfCondition.cur++;
                        if(orderLockOfCondition.cur>=100)return;
                        orderLockOfCondition.conditions[orderLockOfCondition.cur%3].signal();
                    }finally {
                        orderLockOfCondition.lock.unlock();
                    }
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
