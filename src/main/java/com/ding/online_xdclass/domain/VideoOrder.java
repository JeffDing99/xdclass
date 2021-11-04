package com.ding.online_xdclass.domain;

import java.util.Date;

/**
 * 小滴课堂 订单对象
 * `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `out_trade_no` varchar(64) DEFAULT NULL COMMENT '订单唯一标识',
 *   `state` int(11) DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
 *   `create_time` datetime DEFAULT NULL COMMENT '订单生成时间',
 *   `total_fee` int(11) DEFAULT NULL COMMENT '支付金额，单位分',
 *   `video_id` int(11) DEFAULT NULL COMMENT '视频主键',
 *   `video_title` varchar(256) DEFAULT NULL COMMENT '视频标题',
 *   `video_img` varchar(256) DEFAULT NULL COMMENT '视频图片',
 *   `user_id` int(12) DEFAULT NULL COMMENT '用户id',
 */
public class VideoOrder {

    private Integer id;


    private String outTradeNo;

    private Integer state;

    private Date createTime;

    private  Integer totalFee;

    private Integer videoId;

    private String videoTitle;

    private String videoImg;

    private Integer userId;


    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
