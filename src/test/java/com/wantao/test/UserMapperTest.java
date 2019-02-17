package com.wantao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wantao.bean.User;
import com.wantao.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class UserMapperTest {
	@Autowired
	UserService userService;
	private static final Logger logger=LoggerFactory.getLogger("UserMapperTest.class");
	
	
    /**
     * @param
     * @return void
     * @description 插入一个用户
     */
    @Test
	public void testInsertUser() {
      User user=new User();
      user.setUserName("Selenium887");
      user.setUserPassword("213");
      user.setUserNickname("insert8887");
      user.setUserEmail("3213123@qq.com");
      userService.insertUser(user);
	}
    /**
     * @param
     * @return void
     * @description 批量插入多个用户,为分页准备数据
     */
    @Test
    public void testInsertUserByBatch() {
    	List<User> users=new ArrayList<>();
    	for(int i=0;i<1000;i++) {
    		User user=new User();
    		String username=UUID.randomUUID().toString().substring(0, 6);
    		user.setUserName(username);
    	      user.setUserNickname(username+"nickname");
    	      user.setUserEmail(username+"@qq.com");
    	      user.setUserPassword("111111");
    	      user.setUserAvatar("/resource/avatar/avatar0.jpg");
    	      users.add(user);
    	}
    	userService.insertUserByBatch(users);
    }
    /**
     * @param
     * @return void
     * @description 通过id查找用户
     */
    @Test
    public void testSelectUserById() {
    	User user=userService.selectUserById(1);
    	logger.info(user.getUserLastLoginTime()+"");
    }
    
    /**
     * @param
     * @return void
     * @description 通过id更新用户
     */
    @Test
    public void testUpdateUserById() {
    	User user=new User();
    	user.setUserId(1);
    	user.setUserName("admin");
    	userService.updateUserByUserId(user);
    }
    
    @Test
    public void testDeleteUserByBatchById() {
    	List<Integer>ids=new ArrayList<>();
    	ids.add(7777);
       userService.deleteUserByBatchById(ids);
    }
    
}
