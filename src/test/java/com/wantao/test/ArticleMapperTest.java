package com.wantao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wantao.bean.Article;
import com.wantao.service.ArticleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class ArticleMapperTest {
	@Autowired
	ArticleService articleService;
	private final static Logger logger = LoggerFactory.getLogger("ArticleMapperTest.class");

	@Test
	public void testSelectAllArticle() {
		List<Article> articles = articleService.selectAllArticle();
		for (Article article : articles) {
			logger.info(article.getArticleUserId()+"");
		}
	}

}
