package com.wantao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wantao.bean.Article;

/**
 * @author wantao
 * @date 2019-02-13 23:03
 * @description:article表
 */
@Repository
public interface ArticleMapper {
   public Integer selectArticleCount();
   public List<Article> selectAllArticle();
   public Article selectArticleById(Integer articleId);
   public Integer updateArticleById(Article article);
   public Integer deleteArticleByBatchById(List<Integer>ids);
}