package com.ding.online_xdclass.service;

import com.ding.online_xdclass.model.entity.Video;
import com.ding.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/02 23:08
 * @Version 1.0
 */

public interface VideoService {

    List<Video> listVideo();

    Video findDetailById(int videoId);

    List<VideoBanner> listBanner();
}
