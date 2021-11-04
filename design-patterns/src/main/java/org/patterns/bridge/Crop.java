package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-04 16:49
 */
public abstract class Crop {

    protected Product product;

    public Crop(Product product){
        this.product = product;
    }

    protected void makeMoney() {
        this.product.beProducted();
        this.product.beSelled();
    }

}
