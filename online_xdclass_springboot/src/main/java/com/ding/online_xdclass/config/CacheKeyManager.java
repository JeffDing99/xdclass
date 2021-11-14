package com.ding.online_xdclass.config;

/**
 * @Description 缓存key管理类
 * @Author 丁帅帅
 * @Date 21/11/07 10:25
 * @Version 1.0
 */
public class CacheKeyManager {

    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 首页视频列表缓存key
     */

    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 首页视频详情缓存key,%s是视频id
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";

}
