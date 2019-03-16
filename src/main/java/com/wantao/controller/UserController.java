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
import com.wantao.bean.Comment;
import com.wantao.bean.Contact;
import com.wantao.bean.Me;
import com.wantao.bean.Tag;
import com.wantao.service.ArticleCategoryRefService;
import com.wantao.service.ArticleService;
import com.wantao.service.ArticleTagRefService;
import com.wantao.service.CommentService;
import com.wantao.service.ContactService;
import com.wantao.service.MeService;
import com.wantao.service.MessageService;
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
	@Autowired
	ArticleTagRefService articleTagRefService;
	@Autowired
	CommentService commentService;
	@Autowired
	MessageService messageService;
	private static final Logger logger = LoggerFactory.getLogger("UserController.class");

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
	
	/**
	 * @param
	 * @return String
	 * @description 跳转留言页面
	 */
	@RequestMapping("/message")
	public String message() {
		return "user/message";
	}
	

	@GetMapping("/article/{pn}")
	public String article(Model model, @PathVariable("pn") Integer pn) {
		model.addAttribute("ARTICLE_ID", pn);
		return "user/article";
	}

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
	 * @return 
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
		List<Article> relateArticles = articleTagRefService.selectRelateArticle(articleId);
		List<Tag> tags = articleTagRefService.selectTagByArticleId(articleId);
		return Message.success().add("article", article).add("category", category).add("tags", tags)
				.add("relateArticles", relateArticles);
	}
	
	/**
	 * @param
	 * @return 
	 * @description 增加评论
	 */
	@PostMapping("/addComment")
	@ResponseBody
	public Message addComment(Comment comment, HttpServletRequest request) {
		//logger.info(comment.toString());
		comment.setCommentCreateTime(new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date()));
		comment.setCommentIp(request.getRemoteAddr());
		comment.setAnswer(0);
		commentService.insertComment(comment);
		return Message.success();
	}
	
	@GetMapping("/selectCommentsByArticleId")
	@ResponseBody
	public Message selectCommentsByArticleId(@RequestParam("articleId")Integer articleId) {
		List<Comment> comments=commentService.selectCommentsByArticleId(articleId);
		return Message.success().add("comments",comments);
	}
	
	@GetMapping("/selectAllMessage/{pn}")
	@ResponseBody
	public Message selectAllMessage(@PathVariable("pn")Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<com.wantao.bean.Message> messages=messageService.selectAllMessage();
		PageInfo pageInfo = new PageInfo(messages, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}
	
}
