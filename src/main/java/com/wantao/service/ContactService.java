package com.wantao.service;

import java.util.List;

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

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ContactMapper#addContact(com.wantao.bean.Contact)
	 * 添加联系人
	 */
	@Override
	public Integer addContact(Contact contact) {
		return contactMapper.addContact(contact);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ContactMapper#selectAllContact()
	 * 查询所有联系人
	 */
	@Override
	public List<Contact> selectAllContact() {
		return contactMapper.selectAllContact();
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ContactMapper#deleteContactByBatchById(java.util.List)
	 * 批量删除联系人
	 */
	@Override
	public Integer deleteContactByBatchById(List<Integer> ids) {
		return contactMapper.deleteContactByBatchById(ids);
	}

	@Override
	public Integer updateContactByBatchById(List<Integer> ids) {
		return contactMapper.updateContactByBatchById(ids);
	}

}
