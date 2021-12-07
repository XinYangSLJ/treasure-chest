package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:50
 */
public class Client {

    public static void main(String[] args) {
        IWomen tong = new TongXiangYuImpl(WomanTypeEnum.FATHER.getCode(), "我要去动物园看大熊猫！");
        FatherHandler handler = new FatherHandler();
        HusbandHandler husbandHandler = new HusbandHandler();
        SonHandler sonHandler = new SonHandler();
        handler.setNext(husbandHandler);
        husbandHandler.setNext(sonHandler);
        handler.handleMessage(tong);
    }


}
