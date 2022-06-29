package org.treasure.chest.dev.template.common.result;

import org.treasure.chest.dev.template.common.enums.CodeEnum;

import java.io.Serializable;

/**
 * @author lj
 * @version 1.0.0
 * @Description 统一结果封装对象
 * @createTime 2022-06-17 13:48
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -6381191585176915639L;
    /**
     * 响应状态码 0000表示成功，9999表示失败
     */
    private String code;

    /**
     * 响应结果描述
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response= new BaseResponse<>();
        response.setCode(CodeEnum.SUCCESS.getCode());
        response.setMessage(CodeEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    /**
     *  失败返回
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> fail(String code, String message) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

}
