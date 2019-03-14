package com.wantao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.wantao.bean.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.wantao.bean.Category;

/**
 * @author wantao
 * @date 2019-02-12 13:04
 * @description: 文章类
 */
@Data
/**
 * @param articleId           文章id
 * @param articleUserId       文章作者id
 * @param articleUserName     文章作者name
 * @param articleTitle        文章标题
 * @param articleViewCount    文章浏览数量
 * @param articleCommentCount 文章评论数量
 * @param articleDislikeCount 不喜欢的数量
 * @param articleLikeCount    喜欢的数量
 * @param articleCreateTime   文章创建书剑
 * @param articleUpdateTime   文章更新时间
 * @param articleIsComment    是否允许评论 1允许评论 0不允许评论
 * @param articleStatus       文章状态 1有效 2无效
 * @param articleOrder        文章顺序 0为置顶1为正常
 * @param articleContent      文章内容
 * @param tagList             标签列表
 * @param categoryList        分类列表
 */
@AllArgsConstructor
public class Article implements Serializable {
	private static final long serialVersionUID = 6722965489683569650L;
	private Integer articleId;
	private Integer articleUserId;
	private String articleUserName;
	private String articleTitle;
	private Integer articleViewCount;
	private Integer articleCommentCount;
	private Integer articleDislikeCount;
	private Integer articleLikeCount;
	private String articleCreateTime;
	private String articleUpdateTime;
	private Integer articleIsComment;
	private Integer articleStatus;
	private Integer articleOrder;
	private String articleContent;

	public Article() {
	};
}
