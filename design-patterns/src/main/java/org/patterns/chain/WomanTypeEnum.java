package org.patterns.chain;



import java.util.Arrays;


public enum WomanTypeEnum {

    FATHER(1,"未成年,凡事要听家长的意见"),
    HAS_HUSBAND(2,"已婚，凡事要和丈夫商量"),
    HAS_SON(3,"老伴不在了，有事情找孩子"),
    ;

    WomanTypeEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }
    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static WomanTypeEnum getEnumByCode(Integer code){
        return Arrays.asList(WomanTypeEnum.values()).stream()
                .filter(typeEnum -> typeEnum.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

}
