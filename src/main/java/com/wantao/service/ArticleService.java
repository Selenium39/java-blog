package com.wantao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
