package com.ding.online_xdclass.mapper;

import com.ding.online_xdclass.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/04 15:58
 * @Version 1.0
 */
@Repository
public interface UserMapper {
    int save(User user);

    User findByPhone(@Param("phone") String phone);
}
