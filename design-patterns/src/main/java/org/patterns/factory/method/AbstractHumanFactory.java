package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 *   去掉抽象工厂类，直接将createHuman方法静态话，相对应的类图变简单了，而且调用者也比较简单，该模式是
 *   工厂方法模式的弱化，因为简单，所以称为简单工厂模式（Simple Factory Pattern），也叫做
 *   静态工厂模式。
 * @createTime 2021-12-06 17:08
 */
public abstract class AbstractHumanFactory {
    protected abstract <T extends IHuman> T createHuman(Class<T> c);
}
