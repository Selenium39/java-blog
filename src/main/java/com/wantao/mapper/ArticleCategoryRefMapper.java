package com.wantao.mapper;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Category;

@Repository
public interface ArticleCategoryRefMapper {
	public Category selectCategoryByArticleId(Integer articleId);

}
