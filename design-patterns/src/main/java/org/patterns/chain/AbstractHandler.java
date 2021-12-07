package org.patterns.chain;

import java.util.Objects;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 11:08
 */
public abstract class AbstractHandler {

    protected Integer handleType;

    protected AbstractHandler nextHandler;

    final void handleMessage(IWomen women){
        int type = women.getType();
        if(handleType.equals(type)){
            System.out.println("======="+WomanTypeEnum.getEnumByCode(type).getValue());
            System.out.println(women.getRequest());
            response();
        }else {
            if(Objects.isNull(nextHandler)){
                System.out.println("不受约束，自行决定！");
            }else {
                nextHandler.handleMessage(women);
            }
        }
    }

    public void setNext(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    abstract void response();
}
