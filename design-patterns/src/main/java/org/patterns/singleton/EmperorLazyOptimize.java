package org.patterns.singleton;

import java.util.Objects;

/**
 * @author lj
 * @version 1.0.0
 * @Description 懒汉式 (静态内部类)
 * @createTime 2021-12-06 11:25
 */
public class EmperorLazyOptimize {

    private static class EmperorHolder {
        private static EmperorLazyOptimize emperor = new EmperorLazyOptimize();
    }

    private EmperorLazyOptimize(){}

    public static EmperorLazyOptimize getInstance() {
        return EmperorHolder.emperor;
    }

    public void say(){
        System.out.println("朕！！！要睡个懒觉，今天不早朝");
    }
}
