package com.wantao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wantao.bean.Category;
import com.wantao.service.ArticleCategoryRefService;
import com.wantao.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml" })
public class ArticleCategoryRefMapperTest {
	@Autowired
	ArticleCategoryRefService articleCategoryRefService;
	private final static Logger logger = LoggerFactory.getLogger("ArticleCategoryRefMapperTest.class");
    
	/**
	 * @param
	 * @return void
	 * @description 测试通过articleId查询到对应的Category
	 */
	@Test
	public void testSelectCategoryByArticleId() {
		Category category=articleCategoryRefService.selectCategoryByArticleId(1);
		logger.info(category.toString());
	}

}
