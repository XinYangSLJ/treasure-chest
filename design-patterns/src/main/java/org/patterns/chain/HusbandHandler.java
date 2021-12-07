package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:28
 */
public class HusbandHandler extends AbstractHandler{

    HusbandHandler(){
        super();
        this.handleType = WomanTypeEnum.HAS_HUSBAND.getCode();
    }

    @Override
    void response() {
        System.out.println("丈夫同意你的意见");
    }
}
