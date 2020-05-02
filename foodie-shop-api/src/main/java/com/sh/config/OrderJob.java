package com.sh.config;

import com.sh.utils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderJob
 * @Desc
 * @Author leeshuhua
 * @Date 2020/5/2 12:05
 * @Version V1.0
 **/
@Component
public class OrderJob {

    @Scheduled(cron = "0/3 * * * * ?")
    public void closeOrder(){

        System.out.println("定时器执行了，当前时间为"+ DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
