package org.patterns.observer;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * 观察者模式（Observer Pattern）也叫做发布订阅模式（Publish/subscribe）,它是一个在项
 * 目中经常使用的模式，其定义如下：定义对象间一种一对多的依赖关系，使得每
 * 当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 *● Subject被观察者
 * 定义被观察者必须实现的职责，它必须能够动态地增加、取消观察者。它一般是抽象类
 * 或者是实现类，仅仅完成作为被观察者必须实现的职责：管理观察者并通知观察者。
 * ● Observer观察者
 * 观察者接收到消息后，即进行update（更新方法）操作，对接收到的信息进行处理。
 * ● ConcreteSubject具体的被观察者
 * 定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。
 * ● ConcreteObserver具体的观察者
 * 每个观察在接收到消息后的处理反应是不同，各个观察者有自己的处理逻辑。
 *
 * @createTime 2021-11-05 11:33
 */
public class Client {

    public static void main(String[] args) {
        FeiZiHanImpl feiZiHan = new FeiZiHanImpl();
        Observer siLi = new SiLiObserver();
        feiZiHan.addObserver(siLi);
        feiZiHan.haveFun();
        feiZiHan.haveBreakfast();
    }

}
