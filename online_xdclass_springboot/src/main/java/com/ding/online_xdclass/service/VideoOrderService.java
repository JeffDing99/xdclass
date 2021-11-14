package com.ding.online_xdclass.service;

import com.ding.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/06 22:14
 * @Version 1.0
 */
public interface VideoOrderService {

    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
