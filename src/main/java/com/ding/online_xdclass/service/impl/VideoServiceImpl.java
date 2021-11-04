package com.ding.online_xdclass.service.impl;

import com.ding.online_xdclass.domain.Video;
import com.ding.online_xdclass.domain.VideoBanner;
import com.ding.online_xdclass.mapper.VideoMapper;
import com.ding.online_xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/02 23:09
 * @Version 1.0
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }


    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        //需要使用关联复杂查询
        Video video = videoMapper.findDetailById(videoId);

        return video;
    }
}
