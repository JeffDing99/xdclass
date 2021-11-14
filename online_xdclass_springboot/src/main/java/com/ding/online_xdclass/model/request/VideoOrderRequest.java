package com.ding.online_xdclass.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/06 23:05
 * @Version 1.0
 */
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
