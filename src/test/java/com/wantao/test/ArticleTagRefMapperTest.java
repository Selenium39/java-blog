package com.wantao.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wantao.bean.Article;
import com.wantao.bean.Category;
import com.wantao.service.ArticleTagRefService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class ArticleTagRefMapperTest {
	@Autowired
	ArticleTagRefService articleTagRefService;
	private final static Logger logger = LoggerFactory.getLogger("ArticleTagRefMapperTest.class");
    
	/**
	 * @param
	 * @return void
	 * @description 测试通过articleId查询到推荐的文章
	 */
	@Test
	public void testselectRelateArticle() {
		List<Article>articles=articleTagRefService.selectRelateArticle(29);
		for(Article article:articles) {
			logger.info(article.toString());
		}
	}

}
