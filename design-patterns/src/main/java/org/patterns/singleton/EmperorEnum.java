package org.patterns.singleton;

/**
 * @author lj
 * @version 1.0.0
 * @Description 枚举式单例
 * @createTime 2021-12-06 13:52
 */
public enum EmperorEnum {

    INSTANCE;

    public void say(){
        System.out.println("朕！！！");
    }
}
