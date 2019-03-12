package com.wantao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Category;
import com.wantao.mapper.ArticleCategoryRefMapper;

@Service
public class ArticleCategoryRefService implements ArticleCategoryRefMapper {
	@Autowired
	ArticleCategoryRefMapper articleCategoryRefMapper;

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleCategoryRefMapper#selectCategoryByArticleId(java.lang.Integer)
	 * 通过articleId查询article对应的分类
	 */
	@Override
	public Category selectCategoryByArticleId(Integer articleId) {
		return articleCategoryRefMapper.selectCategoryByArticleId(articleId);
	}

}
