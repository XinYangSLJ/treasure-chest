package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description 风口公司，哪种产品赚钱制作哪种产品
 * @createTime 2021-11-04 17:20
 */
public class FengkouCrop extends Crop{

    public FengkouCrop(Product product) {
        super(product);
    }

    protected void makeMoney() {
        super.makeMoney();
        System.out.println("赚钱了。。。");
    }
}
