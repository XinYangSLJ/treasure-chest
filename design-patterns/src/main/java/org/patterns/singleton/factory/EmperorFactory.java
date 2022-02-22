package org.patterns.singleton.factory;

import java.lang.reflect.Constructor;

/**
 * @author lj
 * @version 1.0.0
 * @Description 利用工厂方法模式创建单例
 * @createTime 2021-12-08 16:31
 */
public class EmperorFactory {

    private static EmperorPrivate emperor = null;

    static {
        try {
            Class<?> aClass = Class.forName(EmperorPrivate.class.getName());
            Constructor<?> constructor = aClass.getConstructor();
            constructor.setAccessible(true);
            emperor = (EmperorPrivate) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EmperorPrivate getInstance() {
        return emperor;
    }
}
