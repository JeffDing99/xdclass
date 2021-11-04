package com.ding.online_xdclass.mapper;

import com.ding.online_xdclass.model.entity.Video;
import com.ding.online_xdclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/02 23:05
 * @Version 1.0
 */
@Repository
public interface VideoMapper {

    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图
     * @return
     */
    List<VideoBanner> listVideoBanner();

    Video findDetailById(@Param("video_id") int videoId);
}
