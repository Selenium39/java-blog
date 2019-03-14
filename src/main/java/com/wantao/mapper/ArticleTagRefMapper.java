package com.wantao.mapper;

import java.util.List;
import java.util.Map;

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

}
