package com.sfs.experimentaltesting;

import cn.hutool.core.util.IdUtil;
import com.sfs.experimentaltesting.config.ThreadPoolConfig;
import com.sfs.experimentaltesting.dao.mapper.PhoneOrderWaitPushMapper;
import com.sfs.experimentaltesting.domin.phoneBill.PhoneOrderWaitPushNew;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

import static jodd.util.ThreadUtil.sleep;

@SpringBootTest
@Log4j2
class ExperimentalTestingApplicationTests {

    @Resource
    PhoneOrderWaitPushMapper phoneOrderWaitPushMapper;

    @Test
    void contextLoads() {
//        List<PhoneOrderWaitPushNew> phoneOrderWaitPushNews = new ArrayList<>();
//
//        PhoneOrderWaitPushNew phoneOrderWaitPushNew = new PhoneOrderWaitPushNew();
//        phoneOrderWaitPushNew.setClassifyName("移動");
//        phoneOrderWaitPushNew.setShopUserId(10086L);
//        phoneOrderWaitPushNew.setUpstreamUserId(1717171L);
//        phoneOrderWaitPushNew.setPlatformOrderNo(IdUtil.getSnowflake(0, 0).nextIdStr() + "shopOrderNo");
//        phoneOrderWaitPushNew.setShopOrderNo("1111");
//        phoneOrderWaitPushNew.setUpstreamOrderNo("1112");
//        phoneOrderWaitPushNews.add(phoneOrderWaitPushNew);
//
//        phoneOrderWaitPushMapper.saveBatch(phoneOrderWaitPushNews);
        Long count = phoneOrderWaitPushMapper.selectCount(null);
        System.out.println(count);
    }


    @Test
    void saveBatch() {
        log.info(new Date());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int k = 0; k < 100; k++) {
                    List<PhoneOrderWaitPushNew> phoneOrderWaitPushNews = new ArrayList<>();
                    for (int j = 0; j < 10000; j++) {
                        PhoneOrderWaitPushNew phoneOrderWaitPushNew = new PhoneOrderWaitPushNew();
                        phoneOrderWaitPushNew.setClassifyName("移動");
                        phoneOrderWaitPushNew.setShopUserId(10086L);
                        phoneOrderWaitPushNew.setUpstreamUserId(1717171L);
                        phoneOrderWaitPushNew.setPlatformOrderNo(IdUtil.getSnowflake(0, 0).nextIdStr() + "shopOrderNo");
                        phoneOrderWaitPushNew.setPlatformOrderNo(IdUtil.getSnowflake(1, 1).nextIdStr() + "shopOrderNo");
                        phoneOrderWaitPushNew.setPlatformOrderNo(IdUtil.getSnowflake(2, 2).nextIdStr() + "shopOrderNo");
                        phoneOrderWaitPushNews.add(phoneOrderWaitPushNew);
                    }
                    phoneOrderWaitPushMapper.saveBatch(phoneOrderWaitPushNews);

                }
                log.info(new Date());
            }).start();
            sleep(5000);
        }

    }



//    @Resource
//    ThreadPoolTaskExecutor myTaskExecutor;
//    @Test
//    public void jj(){
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        Callable
//
//    }



}
