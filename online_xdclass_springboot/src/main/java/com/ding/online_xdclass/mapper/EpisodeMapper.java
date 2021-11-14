package com.ding.online_xdclass.mapper;

import com.ding.online_xdclass.model.entity.Episode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/07 08:38
 * @Version 1.0
 */
@Repository
public interface EpisodeMapper {

    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
