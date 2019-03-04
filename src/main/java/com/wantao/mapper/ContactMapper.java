package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Comment;
import com.wantao.bean.Contact;

/**
 * @author wantao
 * @date 2019-02-27 22:20
 * @description: contact表
 */
@Repository
public interface ContactMapper {
   public Integer addContact(Contact contact);
   public List<Contact> selectAllContact();
   public Integer deleteContactByBatchById(List<Integer>ids);
   public Integer updateContactByBatchById(List<Integer>ids);
}
