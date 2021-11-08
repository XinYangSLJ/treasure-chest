package org.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-05 11:08
 */
public class FeiZiHanImpl extends Observable implements IFeiZiHan {

    private String name = "韩非子";


    @Override
    public void haveFun() {
        notifyAllObservers(name);
        System.out.println("娱乐放松一下，打会豆豆。。。");
    }

    @Override
    public void haveBreakfast() {
        notifyAllObservers(name);
        System.out.println("饿了，我要吃饭了。。。");
    }
}
