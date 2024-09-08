package com.sfs.experimentaltesting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class SchedulePoolConfig {
    @Bean
    public TaskScheduler taskScheduler() {
        //定时任务线程池
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 设置线程池大小为10
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }

}
