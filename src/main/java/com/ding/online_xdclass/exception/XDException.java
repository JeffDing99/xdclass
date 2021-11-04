package com.ding.online_xdclass.exception;

/**
 * @Description 自定义异常类
 * @Author 丁帅帅
 * @Date 21/11/04 15:25
 * @Version 1.0
 */
public class XDException extends RuntimeException{

    private Integer code;
    private String msg;

    public XDException( Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
