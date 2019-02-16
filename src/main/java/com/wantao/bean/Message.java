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
 * @param messageId
 * @param userId
 * @param content
 * @param messageCreateTime
 */
@AllArgsConstructor
public class Message implements Serializable {
	private static final long serialVersionUID = -181550064979924929L;
	private Integer messageId;
	private Integer userId;
	private String content;
	private Date messageCreateTime;
	public Message() {
		super();
	}
	

}
