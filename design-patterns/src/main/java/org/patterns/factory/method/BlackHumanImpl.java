package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 17:20
 */
public class BlackHumanImpl implements IHuman {

    @Override
    public void getColor() {
        System.out.println("黑皮肤的非美人");
    }

    @Override
    public void talk() {
        System.out.println("我们的语言有，非洲土语。。。");
    }
}
