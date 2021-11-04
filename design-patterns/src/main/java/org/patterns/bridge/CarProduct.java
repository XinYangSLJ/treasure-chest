package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-04 17:15
 */
public class CarProduct extends Product{

    @Override
    void beProducted() {
        System.out.println("众泰Mini被制造。。。");
    }

    @Override
    void beSelled() {
        System.out.println("众泰Mini被销售。。。");
    }
}
