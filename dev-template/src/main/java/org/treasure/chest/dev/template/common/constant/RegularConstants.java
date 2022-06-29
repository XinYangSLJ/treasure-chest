package org.treasure.chest.dev.template.common.constant;


/**
 * @Description: 输入校验规则（正则表达式）
 * @Author: lijun.shen
 * @Date: 2020/03/18 11:13
 * @Version: 1.0
 */
public class RegularConstants {

    /**
     * 订单中心订单号
     */
    public static class DM_ORDER_ID {
        public static final String REG = "(^$)|(^[1-9]\\d*$)";
        public static final String DESC = "订单不存在，请重新扫描";
    }

    /**
     * 手机号
     */
    public static class PHONE_NUMBER {
        public static final String REG = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
        public static final String DESC = "手机号格式不正确，请确认后重新输入";
    }

}
