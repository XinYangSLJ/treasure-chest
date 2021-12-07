package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 13:28
 */
public class DefaultHandler extends AbstractHandler{

    @Override
    void response() {
        System.out.println("你可以自行决定");
    }
}
