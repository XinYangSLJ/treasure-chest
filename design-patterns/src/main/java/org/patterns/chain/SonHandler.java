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
        this.handleType = 3;
    }

    @Override
    void response() {
        System.out.println("儿子同意你的请求");
    }
}
