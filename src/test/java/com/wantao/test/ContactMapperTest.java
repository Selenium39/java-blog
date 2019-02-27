package com.wantao.test;

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
}
