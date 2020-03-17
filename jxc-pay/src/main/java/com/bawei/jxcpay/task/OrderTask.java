package com.bawei.jxcpay.task;


import com.bawei.jxcpay.entity.Ding;
import com.bawei.jxcpay.mapper.DingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderTask {

    @Autowired(required = false)
    DingMapper iDingService;

    /**
     * 处理调单
     */
//    @Scheduled(cron = "0/10 * * * * ?")
//    @Async
    public void order(){
        List<Ding> list = iDingService.selectStu(0);
        System.out.println(list);
        for (Ding ding:list) {
            log.info("正在处理订单");
            ding.setStatu(1);
            int i = iDingService.updatee(ding);
        }
    }
}
