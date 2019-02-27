package com.wantao.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-02-27 11:27
 * @description: 个人信息类
 */

/**
 * @param id 个人id
 * @param name 个人姓名
 * @param avatar 个人头像
 * @param password 个人密码
 * @param nickname 个人昵称
 * @param gender 个人性别 1:男性 2:女性
 * @param age  个人年龄
 * @param phone 个人电话
 * @param email 个人邮箱
 * @param title 个人简介标题
 * @param viceTitle 个人简介副标题
 * @param introduction 个人简介内容
 */
@Data
@AllArgsConstructor
public class Me implements Serializable{
	private static final long serialVersionUID = 8074496952343192128L;
	private Integer id;
	private String name;
	private String avatar;
	private String password;
	private String nickname;
	private Integer gender;
	private Integer age; 
	private String phone;
	private String email;
	private String title;
	private String viceTitle;
	private String introduction;
	public Me() {};

}
