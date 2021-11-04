package com.ding.online_xdclass.controller;

import com.ding.online_xdclass.domain.Video;
import com.ding.online_xdclass.domain.VideoBanner;
import com.ding.online_xdclass.service.VideoService;
import com.ding.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ValueRange;
import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/02 23:10
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner() {

        List<VideoBanner> bannerList = videoService.listBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo () {

        List<Video> videoList = videoService.listVideo();
        return JsonData.buildSuccess(videoList);
    }

    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDataById(@RequestParam(value = "video_id",required = true)int videoId) {

        Video video = videoService.findDetailById(videoId);
        int i= 1/0;
        return JsonData.buildSuccess(video);
    }
}
