package com.wantao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wantao.bean.Article;
import com.wantao.bean.Category;

/**
 * @author wantao
 * @date 2019-03-14 3:56:21 PM
 * @description article_category_ref表
 */
@Repository
public interface ArticleCategoryRefMapper {
	public Category selectCategoryByArticleId(Integer articleId);
    public Integer insertArticleCategoryRef(@Param("newArticleId")Integer newArticleId,@Param("categoryId")Integer categoryId);
    public Integer updateArticleCategoryRef(@Param("articleId")Integer articleId,@Param("categoryId")Integer categoryId);
    public List<Article> selectArticleByCategoryId(Integer categoryId);
    public List<Category> selectMostArticleCategory4();
}
