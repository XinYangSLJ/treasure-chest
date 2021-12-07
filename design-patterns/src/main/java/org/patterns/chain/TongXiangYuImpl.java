package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 11:16
 */
public class TongXiangYuImpl implements IWomen{

    private int type;

    private String request;

    public TongXiangYuImpl(int type, String request) {
        this.type = type;
        this.request = request;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getRequest() {
        return request;
    }
}
