package org.treasure.chest.dev.template.common.enums;

import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Description: 下单来源枚举值
 * @Author: lijun.shen
 * @Date: 2021/01/07 15:24
 * @Version: 1.0
 */
@Getter
public enum OrderOriginEnum implements Serializable {


    // 对应到店购
    MARKET(3, "商超"),
    WEB_APP(5,"m端"),
    WEB_CHAT(8,"微信商城"),
    THIRD_APP(12,"福礼购三方应用"),
        ;

    private Integer code;
    private String message;

    OrderOriginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OrderOriginEnum getByCode(Integer code) {
        return Arrays.asList(OrderOriginEnum.values()).stream()
                .filter(m -> m.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
