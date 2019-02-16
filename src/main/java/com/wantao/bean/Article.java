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
 * @param articleId
 * @param articleUserId
 * @param articleTitle
 * @param articleViewCount
 * @param articleCommentCount
 * @param articleLikeCount
 * @param articleCreateTime
 * @param articleUpdateTime
 * @param articleIsComment
 * @param articleStatus
 * @param articleOrder
 * @param articleContent
 * @param user
 * @param tagList
 * @param categoryList
 */
@AllArgsConstructor
public class Article implements Serializable {
	private static final long serialVersionUID = 6722965489683569650L;
    private Integer articleId;
    private Integer articleUserId;
    private String articleTitle;
    private Integer articleViewCount;
    private Integer articleCommentCount;
    private Integer articleLikeCount;
    private Date articleCreateTime;
    private Date articleUpdateTime;
    private Integer articleIsComment;
    private Integer articleStatus;
    private Integer articleOrder;
    private String articleContent;
    private User user;
    private List<Tag> tagList;
    private List<Category> categoryList;
    public Article() {};
}
