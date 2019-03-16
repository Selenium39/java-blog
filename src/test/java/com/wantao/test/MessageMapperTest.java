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

import com.wantao.bean.Message;
import com.wantao.bean.User;
import com.wantao.service.MessageService;
import com.wantao.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class MessageMapperTest {
	@Autowired
	MessageService messageService;
	private static final Logger logger=LoggerFactory.getLogger("MessageMapperTest.class");
	
    /**
     * @param
     * @return void
     * @description 批量插入多个用户,为分页准备数据
     */
    @Test
    public void testInsertMessage() {
    	List<Message> messages=new ArrayList<>();
    	for(int i=0;i<1000;i++) {
    		Message message=new Message();
    		String username=UUID.randomUUID().toString().substring(0, 6);
    		message.setMessageUserName(username);
    		message.setAnswer(0);
    		message.setMessageContent(username+"留言");
    		message.setMessageCreateTime("2018-11-25 20:51:54");
    		messageService.insertMessage(message);
    	}
    }
   
}
