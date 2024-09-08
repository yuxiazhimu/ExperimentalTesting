package com.sfs.experimentaltesting.domin.listener;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;




@Getter
@Setter
public class MyEvent extends ApplicationEvent {

    private MyOrder myOrder;
    public MyEvent(Object soures){
        super(soures);

    }

    public MyEvent(Object soures,MyOrder myOrder){
        super(soures);
        this.myOrder=myOrder;
    }




}
