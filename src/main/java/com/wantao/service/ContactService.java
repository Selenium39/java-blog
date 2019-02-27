package com.wantao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Contact;
import com.wantao.mapper.ContactMapper;

/**
 * @author wantao
 * @date 2019-02-27 22:23
 * @description: contact表
 */
@Service
public class ContactService implements ContactMapper {
	@Autowired
	ContactMapper contactMapper;

	@Override
	public Integer addContact(Contact contact) {
		return contactMapper.addContact(contact);
	}

}
