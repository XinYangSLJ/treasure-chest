package org.treasure.chest.dev.template.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author lj
 * @version 1.0.0
 * @Description 封装事件信息 基于 观察者模式
 * @createTime 2021-11-05 17:14
 */
@Data
public class BlockedListEven extends ApplicationEvent {

    private String address;

    private String content;

    public BlockedListEven(Object source) {
        super(source);
    }

    public BlockedListEven(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }
}
