package com.wantao.bean;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
/**
 * @author wantao
 * @date 2019-02-12 13:01
 * @description:用户类
 */
@Data
/**
 * @param userId   用户id
 * @param userName 用户姓名
 * @param userPassword 用户密码
 * @param userNickname 用户昵称
 * @param userEmail 用户邮箱
 * @param userUrl 
 * @param userAvatar 用户头像
 * @param userLastLoginIp 用户登录ip
 * @param userRegisterTime 用户注册时间
 * @param userLastLoginTime 用户上次登录时间
 * @param userStatus 用户状态
 * @param articleCount
 */
@AllArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1511931000133306141L;
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userNickname;
	private String userEmail;
	private String userUrl;
	private String userAvatar;
	private String userLastLoginIp;
	private String userRegisterTime;
	private String userLastLoginTime;
	private Integer userStatus;
	/**
	 * @field Integer  articleCount
	 * 文章数量,不是数据库字段
	 */
	private Integer articleCount;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
