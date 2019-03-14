package com.wantao.mapper;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Category;

/**
 * @author wantao
 * @date 2019-03-14 3:56:21 PM
 * @description article_category_ref表
 */
@Repository
public interface ArticleCategoryRefMapper {
	public Category selectCategoryByArticleId(Integer articleId);

}
