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
	 * @see com.wantao.mapper.ArticleMapper#selectAllArticleWithStatus()
	 * 查询所有有效的文章
	 */
	@Override
	public List<Article> selectAllArticleWithStatus() {
		return articleMapper.selectAllArticleWithStatus();
	}
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectAllArticleWithStatus()
	 * 查询所有置顶的文章
	 */
	@Override
	public List<Article> selectAllArticleWithOrder() {
		return articleMapper.selectAllArticleWithOrder();
	}
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectAllArticleWithoutStatus()
	 * 查询所有无效的文章
	 */
	@Override
	public List<Article> selectAllArticleWithoutStatus() {
		return articleMapper.selectAllArticleWithoutStatus();
	}
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectAllArticleWithoutOrder()
	 * 查询未置顶文章
	 */
	@Override
	public List<Article> selectAllArticleWithoutOrder() {
		return articleMapper.selectAllArticleWithoutOrder();
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
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectArticleByIdWithStatus(java.lang.Integer)
	 * 通过id查询有效的文章
	 */
	@Override
	public Article selectArticleByIdWithStatus(Integer articleId) {
		return articleMapper.selectArticleByIdWithStatus(articleId);
	}
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#insertArticle(com.wantao.bean.Article)
	 * 新增文章
	 */
	@Override
	public Integer insertArticle(Article article) {
		return articleMapper.insertArticle(article);
	}
	
	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#selectCurrentArticleId()
	 * 查询新增文章id
	 */
	@Override
	public Integer selectNewArticleId() {
		return articleMapper.selectNewArticleId();
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.ArticleMapper#updateArticleById1(com.wantao.bean.Article)
	 * 修改文章内容
	 */
	@Override
	public Integer updateArticle1ById(Article article) {
		return articleMapper.updateArticle1ById(article);
	}

}
