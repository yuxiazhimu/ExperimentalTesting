package com.sfs.experimentaltesting.testThread;

public class VolatilePrinting {
    private volatile int currentThreadIndex = 0;  
    private final int numThreads = 3;  
    private final char[] chars = {'A', 'B', 'C'};  
  
    public static void main(String[] args) {  
        VolatilePrinting volatilePrinting = new VolatilePrinting();  
        Thread[] threads = new Thread[volatilePrinting.numThreads];  
        for (int i = 0; i < volatilePrinting.numThreads; i++) {  
            final int threadIndex = i;  
            threads[i] = new Thread(() -> {  
                while (true) {  
                    synchronized (volatilePrinting) {  
                        while (volatilePrinting.currentThreadIndex % volatilePrinting.numThreads != threadIndex) {  
                            try {  
                                volatilePrinting.wait();  
                            } catch (InterruptedException e) {  
                                Thread.currentThread().interrupt();  
                                return;  
                            }  
                        }  
                        System.out.print(volatilePrinting.chars[threadIndex]);  
                        volatilePrinting.currentThreadIndex++;  
                        if (volatilePrinting.currentThreadIndex >= 100) { // 假设打印100个字符后结束  
                            break;  
                        }  
                        volatilePrinting.notifyAll();  
                    }  
                }  
            });  
        }  
        for (Thread thread : threads) {  
            thread.start();  
        }  
    }  
}
