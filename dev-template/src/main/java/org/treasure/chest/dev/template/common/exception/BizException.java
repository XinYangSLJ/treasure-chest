package org.treasure.chest.dev.template.common.exception;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-06-17 13:58
 */
public class BizException extends RuntimeException {

    private String retCode;

    private String retMessage;

    public BizException() {
        super();
    }

    public BizException(String retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

}
