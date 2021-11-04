package org.patterns.bridge;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-11-04 16:54
 */
public class HouseCrop extends Crop{


    public HouseCrop(HouseProduct product){
        super(product);
    }

    public void makeMoney(){
        super.makeMoney();
        System.out.println("===房屋大卖，赚了好大一笔钱");
    }

}
