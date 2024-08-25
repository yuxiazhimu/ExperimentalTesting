package com.sfs.experimentaltesting.controller;

import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class TestRedisCallback {
//    @Resource
//    private RMapCache<String, String> mapCache;
//
//    @GetMapping("/test")
//    public void  redisCallBack() {
//
//        mapCache.put("key1", "value1", 10, TimeUnit.SECONDS, 5, TimeUnit.SECONDS);
//
//    }
}
