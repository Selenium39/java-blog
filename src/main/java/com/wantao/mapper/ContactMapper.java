package com.wantao.mapper;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Contact;

/**
 * @author wantao
 * @date 2019-02-27 22:20
 * @description: contact表
 */
@Repository
public interface ContactMapper {
   public Integer addContact(Contact contact);
}
