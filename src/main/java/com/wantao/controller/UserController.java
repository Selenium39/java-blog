package com.wantao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wantao.bean.Article;
import com.wantao.bean.Category;
import com.wantao.bean.Contact;
import com.wantao.bean.Me;
import com.wantao.bean.User;
import com.wantao.service.ArticleCategoryRefService;
import com.wantao.service.ArticleService;
import com.wantao.service.ContactService;
import com.wantao.service.MeService;
import com.wantao.util.Message;

/**
 * @author wantao
 * @date 2019-02-13 23:02
 * @description: 控制前台逻辑
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	MeService meService;
	@Autowired
	ContactService contactService;
	@Autowired
	ArticleService articleService;
	@Autowired
	ArticleCategoryRefService articleCategoryRefService;
	private static final Logger logger = LoggerFactory.getLogger("UserController.class");

//---------------------------控制页面跳转-----------------------
	/**
	 * @param
	 * @return String
	 * @description 跳转首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}

	/**
	 * @param
	 * @return String
	 * @description 跳转个人信息页面
	 */
	@RequestMapping("/aboutMe")
	public String aboutMe() {
		return "user/me";
	}

	/**
	 * @param
	 * @return String
	 * @description 跳转博客文章页面
	 */
	@RequestMapping("/blog")
	public String blog() {
		return "user/blog";
	}

	@GetMapping("/article/{pn}")
	public String article(Model model, @PathVariable("pn") Integer pn) {
		model.addAttribute("ARTICLE_ID", pn);
		return "user/article";
	}

//---------------------------ajax请求获取数据-----------------------	
	/**
	 * @param
	 * @return Message
	 * @description 查询个人信息
	 */
	@GetMapping("/selectMe")
	@ResponseBody
	public Message selectMe() {
		Me me = meService.selectMe();
		return Message.success().add("me", me);
	}

	/**
	 * @param
	 * @return Message
	 * @description 增加联系人
	 */
	@PostMapping("/addContact")
	public String addContact(Contact contact, HttpServletRequest request) {
		contact.setSendTime(new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date()));
		contact.setSendIp(request.getRemoteAddr());
		// logger.info("进入到表单提交的方法");
		contact.setAnswer(0);
		contactService.addContact(contact);
		return "user/me";
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询有效文章列表
	 */
	@GetMapping("/selectAllArticle/{pn}")
	@ResponseBody
	public Message selectAllArticle(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Article> articles = articleService.selectAllArticleWithStatus();
		PageInfo pageInfo = new PageInfo(articles, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 根据id查询文章和文章所属分类
	 */
	@GetMapping("/selectArticleById")
	@ResponseBody
	public Message selectArticleById(@RequestParam("articleId") Integer articleId) {
		Article article = articleService.selectArticleByIdWithStatus(articleId);
		Category category = articleCategoryRefService.selectCategoryByArticleId(articleId);
		return Message.success().add("article", article).add("category", category);
	}
}
