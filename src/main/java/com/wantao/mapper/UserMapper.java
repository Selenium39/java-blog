package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.User;

/**
 * @author wantao
 * @date 2019-02-13 20:55
 * @description: user表
 */
@Repository
public interface UserMapper {
       public Integer selectUserCount();
       public List<User>selectAllUser();
       public User selectUserById(Integer userId);
       public Integer insertUser(User user);
       public Integer insertUserByBatch(List<User> users);
       public  Integer updateUserByUserId(User user);
       public Integer deleteUserByBatchById(List<Integer>ids);
}
