package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Article;
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

	@Override
	public Integer insertArticleCategoryRef(Integer newArticleId, Integer categoryId) {
		return articleCategoryRefMapper.insertArticleCategoryRef(newArticleId, categoryId);
	}

	@Override
	public Integer updateArticleCategoryRef(Integer articleId, Integer categoryId) {
		return articleCategoryRefMapper.updateArticleCategoryRef(articleId, categoryId);
	}

	@Override
	public List<Article> selectArticleByCategoryId(Integer categoryId) {
		return articleCategoryRefMapper.selectArticleByCategoryId(categoryId);
	}

	@Override
	public List<Category> selectMostArticleCategory4() {
		return articleCategoryRefMapper.selectMostArticleCategory4();
	}

}
