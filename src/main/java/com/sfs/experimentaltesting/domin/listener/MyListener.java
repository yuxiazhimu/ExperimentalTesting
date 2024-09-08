package com.sfs.experimentaltesting.domin.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyListener{


    @EventListener
    @Async("myTaskExecutor")
    public void handlerEvent(MyEvent myEvent){
        System.out.println("有新的订单，订单号为:"+myEvent.getMyOrder());
    }


}
