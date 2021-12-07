package org.patterns.chain;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-07 11:16
 */
public class TongXianYuImpl implements IWomen{

    @Override
    public int getType() {
        return WomanTypeEnum.HAS_HUSBAND.getCode();
    }

    @Override
    public String getRequest() {
        return "我想出去逛街";
    }
}
