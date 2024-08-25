package com.sfs.experimentaltesting.testThread;

public class orderPrint {
    public volatile int cur;
    public final int max = 3;

    public Thread[] threads;
    public final char[] p = new char[]{'1', '2', '3'};

    public static void main(String[] args) {
        orderPrint orderPrint = new orderPrint();
        orderPrint.threads = new Thread[orderPrint.max];
        for (int i = 0; i < orderPrint.max; i++) {
            final int threadId = i;

                    orderPrint.threads[i] = new Thread(() -> {
                        while(true){
                            synchronized (orderPrint){
                                while (orderPrint.cur % orderPrint.max != threadId) {
                                    try {
                                        orderPrint.wait();
                                    } catch (InterruptedException e) {
                                        return;
                                    }
                                }
                                if (orderPrint.cur >= 100) {
                                    return;
                                }
                                System.out.print(orderPrint.p[threadId]);
                                orderPrint.cur++;
                                orderPrint.notifyAll();
                            }
                        }
                    });


        }
        for (Thread thread : orderPrint.threads) {
            thread.start();
        }
    }
}
