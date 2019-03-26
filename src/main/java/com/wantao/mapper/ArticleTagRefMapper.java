package com.wantao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wantao.bean.Article;
import com.wantao.bean.Tag;

/**
 * @author wantao
 * @date 2019-03-14 3:56:57 PM
 * @description article_tag_ref表
 */
@Repository
public interface ArticleTagRefMapper {
	public List<Tag> selectTagByArticleId(Integer articleId);
    public List<Article> selectRelateArticle(Integer articleId);
    public Integer insertArticleTagRef(@Param("newArticleId")Integer newArticleId,@Param("tagId")Integer tagId);
    public Integer updateArticleTagRef(@Param("articleId")Integer articleId,@Param("tagId")Integer tagId);
}
