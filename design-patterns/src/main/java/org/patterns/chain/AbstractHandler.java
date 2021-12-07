package org.patterns.chain;

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
            System.out.println(women.getRequest());
            response();
        }else {
            nextHandler.handleMessage(women);
        }
    }

    public void setNext(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    abstract void response();
}
