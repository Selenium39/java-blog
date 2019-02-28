package com.wantao.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wantao.bean.Contact;
import com.wantao.service.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class ContactMapperTest {
	@Autowired
	ContactService contactService;

	/**
	 * @param
	 * @return void
	 * @description 测试增加一个联系人
	 */
	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setId(1);
		contact.setName("selenium");
		contact.setPhone("18800269697");
		contact.setEmail("895484122@qq.com");
		contact.setMessage("嘤嘤嘤");
		contact.setSendTime("2019-2-27 22:30:21");
		contact.setSendIp("127.0.0.1");
		contactService.addContact(contact);
	}
	
	/**
	 * @param
	 * @return void
	 * @description 增加1000个联系人,为分页准备数据
	 */
	@Test
	public void testAddContacts() {
		for(int i=0;i<1000;i++) {	
			Contact contact = new Contact();
			String name=UUID.randomUUID().toString().substring(0,6);
			contact.setName(name);
			contact.setPhone("18800269697");
			contact.setEmail(name+"@qq.com");
			contact.setMessage("嘤嘤嘤");
			contact.setSendTime("2019-2-27 22:30:21");
			contact.setSendIp("127.0.0.1");
			contactService.addContact(contact);
		}
	}
	
}
