package com.ding.online_xdclass.service.impl;

import com.ding.online_xdclass.exception.XDException;
import com.ding.online_xdclass.mapper.EpisodeMapper;
import com.ding.online_xdclass.mapper.PlayRecordMapper;
import com.ding.online_xdclass.mapper.VideoMapper;
import com.ding.online_xdclass.mapper.VideoOrderMapper;
import com.ding.online_xdclass.model.entity.Episode;
import com.ding.online_xdclass.model.entity.PlayRecord;
import com.ding.online_xdclass.model.entity.Video;
import com.ding.online_xdclass.model.entity.VideoOrder;
import com.ding.online_xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/06 22:14
 * @Version 1.0
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {


    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 下单操作
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoAndState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }
        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();

        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        //生成播放记录
        if(rows == 1){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if(episode == null){
                throw  new XDException(-1,"视频没有集信息，请运营人员检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }
        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {

        return videoOrderMapper.listOrderByUserId(userId);
    }
}
