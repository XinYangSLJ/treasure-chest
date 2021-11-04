package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-04 16:49
 */
public abstract class Product {

    /**
     * 生产产品
     */
    abstract void beProducted();

    /**
     * 销售产品
     */
    abstract void beSelled();

}
