package com.sfs.experimentaltesting.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.api.map.event.EntryExpiredListener;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Data
@ConfigurationProperties("spring.redisson")
public class RedisConfig {

//    private String host;
//    private String port;
//    private Integer dB=0;
//
//    @Bean
//    public RedissonClient redissonClient(){
//        Config config = new Config();
//        SingleServerConfig singleServerConfig = config.useSingleServer().setDatabase(dB)
//                .setAddress("redis://" + host + ":" + port);
//        RedissonClient redissonClient = Redisson.create();
//        return redissonClient;
//
//    }
//
//    @Bean
//   public RMapCache<String, String> mapCache(RedissonClient redissonClient){
//       RMapCache<String, String> mapCache = redissonClient.getMapCache("myMap");
//       mapCache.addListener((EntryExpiredListener<String, String>) event -> {
//           System.out.println("Key expired: " + event.getValue());
//       });
//       return  mapCache;
//   }

}
