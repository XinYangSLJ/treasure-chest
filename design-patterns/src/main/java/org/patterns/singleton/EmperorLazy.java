package org.patterns.singleton;

import java.util.Objects;

/**
 * @author lj
 * @version 1.0.0
 * @Description 懒汉式
 * @createTime 2021-12-06 11:25
 */
public class EmperorLazy {

    private static volatile EmperorLazy emperor = null;

    private EmperorLazy(){}

    public static EmperorLazy getInstance() {
        if(Objects.isNull(emperor)){
            synchronized (EmperorLazy.class){
                if(Objects.isNull(emperor)){
                    emperor = new EmperorLazy();
                }
            }
        }
        return emperor;
    }

    public void say(){
        System.out.println("朕！！！要睡个懒觉，今天不早朝");
    }
}
