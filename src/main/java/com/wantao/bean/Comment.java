package com.wantao.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wantao
 * @date 2019-02-14 00:44
 * @description: 评论类
 */
@Data
/**
 * @param commentPid
 * @param commentPname
 * @param commentArticleId
 * @param commentAuthorName
 * @param commentAuthorEmail
 * @param commentAuthorUrl
 * @param commnetAhthorAvatar
 * @param commentContent
 * @param commentAgent
 * @param commentIp
 * @param commentCreateTime
 */
@AllArgsConstructor
public class Comment implements Serializable{
	private static final long serialVersionUID = 3872535011425095495L;
    private Integer commentPid;
    private String commentPname;
    private Integer commentArticleId;
    private String commentAuthorName;
    private String commentAuthorEmail;
    private String commentAuthorUrl;
    private String commnetAhthorAvatar;
    private String commentContent;
    private String commentAgent;
    private String commentIp;
    private Date commentCreateTime;
   public Comment() {}
}
