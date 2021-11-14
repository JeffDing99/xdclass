package com.ding.online_xdclass.service.impl;

import com.ding.online_xdclass.config.CacheKeyManager;
import com.ding.online_xdclass.model.entity.Video;
import com.ding.online_xdclass.model.entity.VideoBanner;
import com.ding.online_xdclass.mapper.VideoMapper;
import com.ding.online_xdclass.service.VideoService;
import com.ding.online_xdclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

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


    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {

        Object cacheObj = null;
        try {
            cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST, () -> {

                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });

            if(cacheObj instanceof List) {
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<VideoBanner> listBanner() {

         try {
             Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY,()->{
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();

                System.out.println("从数据库里面找轮播图列表");
                return bannerList;
            });

            if(cacheObj instanceof List){
                List<VideoBanner> bannerList = (List<VideoBanner>)cacheObj;
                return bannerList;
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);

        try{

            Object cacheObject = baseCache.getOneHourCache().get( videoCacheKey, ()->{

                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);

                return video;

            });

            if(cacheObject instanceof Video){

                Video video = (Video)cacheObject;
                return video;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}