package com.ding.online_xdclass.service.impl;

import com.ding.online_xdclass.model.entity.User;
import com.ding.online_xdclass.mapper.UserMapper;
import com.ding.online_xdclass.service.UserService;
import com.ding.online_xdclass.utils.CommonUtils;
import com.ding.online_xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/04 15:56
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if ( user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }

    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if(user == null){
            return null;

        }else {
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }

    /**
     * 解析user对象
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));

            //MD5加密
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")));

            return user;
        } else {
            return null;
        }
    }
    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg() {
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }


}
