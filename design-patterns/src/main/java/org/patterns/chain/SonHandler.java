package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:28
 */
public class SonHandler extends AbstractHandler{

    SonHandler(){
        super();
        this.handleType = WomanTypeEnum.HAS_SON.getCode();
    }

    @Override
    void response() {
        System.out.println("孩子们都支持你的想法");
    }
}
