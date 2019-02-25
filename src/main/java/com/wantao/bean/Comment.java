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
 * @param commentId 评论Id
 * @param commentPid 评论人Id
 * @param commentPname 评论人Name
 * @param commentArticleId 评论文章id
 * @param commentAuthorId 评论文章作者id
 * @param commentAuthorName 评论文章作者name
 * @param commentAuthorEmail 评论文章作者email
 * @param commentAuthorUrl   
 * @param commnetAuthorAvatar 评论作者头像
 * @param commentContent 评论内容
 * @param commentAgent 
 * @param commentIp  评论人的ip
 * @param commentCreateTime 评论的创建时间
 */
@AllArgsConstructor
public class Comment implements Serializable{
	private static final long serialVersionUID = 3872535011425095495L;
	private Integer commentId;
    private Integer commentUserId;
    private String commentUserName;
    private Integer commentArticleId;
    private Integer commentAuthorId;
    private String commentAuthorName;
    private String commentAuthorEmail;
    private String commentAuthorUrl;
    private String commnetAuthorAvatar;
    private String commentContent;
    private String commentAgent;
    private String commentIp;
    private String commentCreateTime;
   public Comment() {}
}
