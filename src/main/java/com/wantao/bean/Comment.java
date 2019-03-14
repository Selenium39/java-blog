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
 * @param commentId 评论id
 * @param commentArticleId 评论文章id
 * @param commentUserName 评论用户名
 * @param commentUserEmail 评论用户email
 * @param commentContent 评论内容
 * @param commentIp 评论人ip
 * @param commentCreateTime 评论创建时间
 */
@AllArgsConstructor
public class Comment implements Serializable{
	private static final long serialVersionUID = 3872535011425095495L;
	private Integer commentId;
	private Integer commentArticleId;
	private String commentUserName;
    private String commentUserEmail;
    private String commentContent;
    private String commentIp;
    private String commentCreateTime;
   public Comment() {}
}
