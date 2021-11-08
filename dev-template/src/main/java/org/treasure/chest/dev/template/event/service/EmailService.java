package org.treasure.chest.dev.template.event.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.treasure.chest.dev.template.event.BlockedListEven;

import java.util.Arrays;
import java.util.List;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-05 17:36
 */
@Component
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blockedList = Arrays.asList("真北路1425号");
    private ApplicationEventPublisher pblisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.pblisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String content){
        if(blockedList.contains(address)){
            pblisher.publishEvent(new BlockedListEven(this,address,content));
        }
        System.out.println("发送邮件。。。");
    }
}
