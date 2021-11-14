package com.ding.online_xdclass.model.request;

/**
 * @Description 登录request
 * @Author 丁帅帅
 * @Date 21/11/04 22:57
 * @Version 1.0
 */
public class LoginRequest {

    private String phone;

    private String pwd;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
