package com.ding.online_xdclass.mapper;

import com.ding.online_xdclass.model.entity.PlayRecord;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/07 08:39
 * @Version 1.0
 */
@Repository
public interface PlayRecordMapper {

    int saveRecord(PlayRecord playRecord);
}
