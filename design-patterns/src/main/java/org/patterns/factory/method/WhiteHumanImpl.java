package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 17:20
 */
public class WhiteHumanImpl implements IHuman {

    @Override
    public void getColor() {
        System.out.println("白皮肤的欧美人");
    }

    @Override
    public void talk() {
        System.out.println("我们的语言有，英语、德语、法语。。。");
    }
}
