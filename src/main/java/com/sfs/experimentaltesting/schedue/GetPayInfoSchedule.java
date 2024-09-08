package com.sfs.experimentaltesting.schedue;

import cn.hutool.http.HttpException;
import cn.hutool.http.HttpUtil;
import com.sfs.experimentaltesting.domin.listener.MyEvent;
import com.sfs.experimentaltesting.domin.listener.MyOrder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import static jodd.util.ThreadUtil.sleep;

@Log4j2
@Component
public class GetPayInfoSchedule {

    private final ThreadPoolTaskExecutor taskExecutor;


    // 通过构造函数注入线程池
    @Autowired
    public GetPayInfoSchedule(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

//    @Scheduled(fixedRate = 500)
//    public void getPayInfo() {
//        Random random = new Random();
//        int size = random.nextInt(1000);
//        if (size > 5000) {
//            size = 500;
//        }
//        for (int i = 0; i < 10000; i++) {
//            taskExecutor.execute(() -> {
//                try {
//
////                    log.info(LocalDateTime.now());
////                String url = "http://localhost:8081/getPayInfo?str=" + taskExecutor.getThreadNamePrefix();
////                String result = HttpUtil.createGet(url)
////                        .timeout(5000) // 设置超时时间为5000毫秒（5秒）
////                        .execute()
////                        .body();
//                    Byte[] bytes=new Byte[1024*1024*100];
//                    System.out.println(bytes);
//                    String result = HttpUtil.get("http://localhost:8081/getPayInfo?str=" + taskExecutor.getThreadNamePrefix());
//                    System.out.println(result + "获取成功");
//                } catch (HttpException e){
//                    log.error(e.getMessage());
//                    log.error(LocalDateTime.now());
//                }
//            });
//
//        }
//    }

    //    @Autowired
//    ApplicationEventPublisher applicationEventPublisher;
//    @Scheduled(fixedRate = 500)
//    public void myListener(){
//        MyOrder myOrder = new MyOrder();
//        myOrder.setId(System.currentTimeMillis());
//        MyEvent myEvent = new MyEvent(this, myOrder);
//        applicationEventPublisher.publishEvent(myEvent);
//    }
    public boolean flag = false;
    @Resource
    ThreadPoolTaskExecutor myTaskExecutor;

    @Scheduled(fixedRate = 500)
    public void t1() {
        myTaskExecutor.execute(()->{
            System.out.println(System.currentTimeMillis() + "t2");
            sleep(4000);
        });
    }

    @Scheduled(fixedRate = 500)
    public void t2() {
        System.out.println(System.currentTimeMillis() + "t2");
        sleep(4000);
    }


}
