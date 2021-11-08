package org.patterns.observer;

/**
 * @author lj
 * @version 1.0.0
 * @Description 李斯观察者
 * @createTime 2021-11-05 11:29
 */
public class SiLiObserver extends Observer{

    @Override
    void doSomething(String name) {
        System.out.println("报告始皇帝，" + name + "正在");
    }
}
