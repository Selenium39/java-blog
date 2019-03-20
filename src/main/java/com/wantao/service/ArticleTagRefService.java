package com.wantao.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Article;
import com.wantao.bean.Tag;
import com.wantao.mapper.ArticleTagRefMapper;

@Service
public class ArticleTagRefService implements ArticleTagRefMapper {
	@Autowired
	ArticleTagRefMapper articleTagRefMapper;

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleCategoryRefMapper#selectCategoryByArticleId(java.lang.Integer)
	 * 通过articleId查询article对应的标签
	 */
	@Override
	public List<Tag> selectTagByArticleId(Integer articleId) {
		return articleTagRefMapper.selectTagByArticleId(articleId);
	}

	@Override
	public List<Article> selectRelateArticle(Integer articleId) {
		return articleTagRefMapper.selectRelateArticle(articleId);
	}

	@Override
	public Integer insertArticleTagRef(Integer articleId, Integer tagId) {
		return articleTagRefMapper.insertArticleTagRef(articleId, tagId);
	}

}
