package org.treasure.chest.dev.template.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author lj
 * @version 1.0.0
 * @Description 事件监听及通知
 * @createTime 2021-11-05 18:06
 */
@Component
public class BlockedListNotifier implements ApplicationListener<BlockedListEven> {

    private String notificationAddress;


    @Override
    public void onApplicationEvent(BlockedListEven event) {
        System.out.println("监听到事件" + event.getContent());
    }
}
