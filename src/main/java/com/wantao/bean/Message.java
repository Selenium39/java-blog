package com.wantao.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-02-14 12:21
 * @description: 留言类
 */
@Data
/**
 * @param messageId 留言id
 * @param messageUserId 留言用户id
 * @param messsageUserName 留言用户name
 * @param messageContent 留言内容
 * @param messageCreateTime 留言创建时间
 */
@AllArgsConstructor
public class Message implements Serializable {
	private static final long serialVersionUID = -181550064979924929L;
	private Integer messageId;
	private String  messageUserName;
	private String messageContent;
	private String messageCreateTime;
	private String messageIp;
	private Integer answer;
	public Message() {
		super();
	}
	

}
