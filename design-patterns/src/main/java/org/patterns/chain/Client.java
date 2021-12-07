package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:50
 */
public class Client {

    public static void main(String[] args) {
        IWomen tong = new TongXianYuImpl();
        FatherHandler handler = new FatherHandler();
        handler.setNext(new HusbandHandler());
        handler.handleMessage(tong);
    }


}
