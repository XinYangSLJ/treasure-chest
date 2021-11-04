package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-04 16:57
 */
public class HouseProduct extends Product{
    @Override
    void beProducted() {
        System.out.println("房屋已建造完成。。。");
    }

    @Override
    void beSelled() {
        System.out.println("房屋已在销售。。。");
    }
}
