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
 * @param phone
 * @param message
 * @param sendTime
 * @param sendIp
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
