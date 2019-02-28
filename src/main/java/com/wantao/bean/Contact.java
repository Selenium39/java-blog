package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-02-27 22:11
 * @description: 联系人类
 */

/**
 * @param id       id
 * @param name     联系人姓名
 * @param email    联系人email
 * @param phone    联系人phone
 * @param message  联系人信息
 * @param sendTime 联系人发送时间
 * @param sendIp   联系人发送ip
 */
@Data
@AllArgsConstructor
public class Contact implements Serializable {
	private static final long serialVersionUID = -4212687018583309417L;
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String message;
	private String sendTime;
	private String sendIp;

	public Contact() {
	};

}
