package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 17:20
 */
public class YellowHumanImpl implements IHuman {

    @Override
    public void getColor() {
        System.out.println("黄皮肤的中国人");
    }

    @Override
    public void talk() {
        System.out.println("我们的语言是汉语");
    }
}
