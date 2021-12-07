package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:28
 */
public class FatherHandler extends AbstractHandler{

    FatherHandler(){
        super();
        this.handleType = 1;
    }

    @Override
    void response() {
        System.out.println("父亲同意你的请求");
    }
}
