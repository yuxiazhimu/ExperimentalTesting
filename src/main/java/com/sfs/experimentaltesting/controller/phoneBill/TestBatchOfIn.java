package com.sfs.experimentaltesting.controller.phoneBill;

import com.sfs.experimentaltesting.conmon.entiry.DateConstant;
import com.sfs.experimentaltesting.dao.mapper.PhoneOrderWaitPushMapper;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@Log4j2
public class TestBatchOfIn {
    @Resource
    PhoneOrderWaitPushMapper phoneOrderWaitPushMapper;

    @GetMapping("/get")
    public List<Long> get(){
        Random random = new Random();
        phoneOrderWaitPushMapper.selectCount(null);
        List<Long> ids=new ArrayList<>(500);
        for (int i = 0; i < 500; i++) {
            long l = random.nextLong()%10000000;
            ids.add(l);
        }
        Date date1 = new Date();
        List<Long> longs = phoneOrderWaitPushMapper.selectBatchOfIn(ids);
        Date date2 = new Date();
        log.info(longs.size());
        log.info(date2.getTime()-date1.getTime());
        return longs;
    }
}
