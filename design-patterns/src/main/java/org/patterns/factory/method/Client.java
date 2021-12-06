package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description 在工厂方法模式中，抽象产品类Product负责定义产品的共性，实现对事物最抽象的定
 * 义；Creator为抽象创建类，也就是抽象工厂，具体如何创建产品类是由具体的实现工厂
 * ConcreteCreator完成的。工厂方法模式的变种较多，我们来看一个比较实用的通用源码。
 * @createTime 2021-12-06 17:25
 */
public class Client {

    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();

        IHuman blackHuman = humanFactory.createHuman(BlackHumanImpl.class);
        blackHuman.getColor();
        blackHuman.talk();

        IHuman yellowHuman = humanFactory.createHuman(YellowHumanImpl.class);
        yellowHuman.getColor();
        yellowHuman.talk();

        IHuman whiteHuman = humanFactory.createHuman(WhiteHumanImpl.class);
        whiteHuman.getColor();
        whiteHuman.talk();
    }
}
