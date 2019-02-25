package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.Article;
import com.wantao.mapper.ArticleMapper;

/**
 * @author wantao
 * @date 2019-02-13 23:05
 * @description: article表
 */
@Service
public class ArticleService implements ArticleMapper {
    @Autowired 
	ArticleMapper articleMapper;
    
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectArticleCount()
	 * 查询文章数量
	 */
	@Override
	public Integer selectArticleCount() {
		return articleMapper.selectArticleCount();
	}
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectAllArticle()
	 * 查询所有文章
	 */
	@Override
	public List<Article> selectAllArticle() {
		return articleMapper.selectAllArticle();
	}
	
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectArticleById()
	 * 通过id查找文章
	 */
	@Override
	public Article selectArticleById(Integer articleId) {
		return articleMapper.selectArticleById(articleId);
	}
	
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#updateArticleById(com.wantao.bean.Article)
	 * 通过id修改文章
	 */
	@Override
	public Integer updateArticleById(Article article) {
		return articleMapper.updateArticleById(article);
	}
	
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#deleteArticleByBatchById(java.util.List)
	 * 通过id单个或者批量删除
	 */
	@Override
	public Integer deleteArticleByBatchById(List<Integer> ids) {
		return articleMapper.deleteArticleByBatchById(ids);
	}

}
