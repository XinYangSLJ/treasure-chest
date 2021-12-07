package org.patterns.chain;



import java.util.Arrays;


public enum WomanTypeEnum {

    GIRL(1,"未成年"),
    HAS_HUSBAND(2,"已婚未育"),
    HAS_SON(3,"丧夫，有一子"),
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
