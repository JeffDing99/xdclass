package com.ding.online_xdclass.service;

import java.util.Map;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/04 15:52
 * @Version 1.0
 */
public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);

    String findByPhoneAndPwd(String phone, String pwd);
}
