package com.sfs.experimentaltesting.synchornize;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {

    Thread[] threads=new Thread[3];
    int cur=0;
    char[] chars=new char[]{'a','b','c'};

    Object object=new Object();
    @Test
    public void py(){
        for (int i = 0; i < 3; i++) {
            final int k=i;
            threads[i]=new Thread(()->{
                while(true){
                    synchronized (object){
                        if(cur%3!=k){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {

                            }
                        }
                        if(cur>=100)return ;
                        System.out.print(chars[cur%3]);
                        cur++;
                        object.notifyAll();
                    }
                }
            });
        }
        for (Thread thread :threads) {
            thread.start();
        }


    }
}
