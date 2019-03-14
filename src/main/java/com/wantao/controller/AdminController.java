package com.wantao.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wantao.bean.Article;
import com.wantao.bean.Category;
import com.wantao.bean.Comment;
import com.wantao.bean.Contact;
import com.wantao.bean.Me;
import com.wantao.bean.Tag;
import com.wantao.bean.User;
import com.wantao.service.ArticleService;
import com.wantao.service.CategoryService;
import com.wantao.service.CommentService;
import com.wantao.service.ContactService;
import com.wantao.service.MeService;
import com.wantao.service.MessageService;
import com.wantao.service.TagService;
import com.wantao.service.UserService;
import com.wantao.util.Message;
import com.wantao.util.PhotoUtil;

/**
 * @author wantao
 * @date 2019-02-13 00:09
 * @description: 控制后台逻辑
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger("AdminController.class");
	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	CommentService commentService;
	@Autowired
	MessageService messageService;
	@Autowired
	MeService meService;
	@Autowired
	ContactService contactService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	TagService tagService;
	// ------------------------------跳转--------------------------------------

	/**
	 * @param
	 * @return String
	 * @description 登录跳转
	 */
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}

	/**
	 * @param
	 * @return String
	 * @description 注册跳转
	 */
	@RequestMapping("/register")
	public String register() {
		return "admin/register";
	}

	/**
	 * @param
	 * @return String
	 * @description 找回密码跳转
	 */
	@RequestMapping("/forgot")
	public String forgot() {
		return "admin/forgot";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有用户跳转
	 */
	@RequestMapping("/users")
	public String users() {
		return "admin/users";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有文章跳转
	 */
	@RequestMapping("/articles")
	public String articles() {
		return "admin/articles";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有文章标签跳转
	 */
	@RequestMapping("/tags")
	public String tags() {
		return "admin/tags";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有文章分类跳转
	 */
	@RequestMapping("/categorys")
	public String categorys() {
		return "admin/categorys";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有评论跳转
	 */
	@RequestMapping("/comments")
	public String comments() {
		return "admin/comments";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看所有留言跳转
	 */
	@RequestMapping("/messages")
	public String messages() {
		return "admin/messages";
	}

	/**
	 * @param
	 * @return String
	 * @description 返回首页跳转
	 */
	@RequestMapping("/home")
	public String home() {
		return "admin/index";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看个人信息跳转
	 */
	@RequestMapping("/me")
	public String me() {
		return "admin/me";
	}

	/**
	 * @param
	 * @return String
	 * @description 查看联系人跳转
	 */
	@RequestMapping("/contact")
	public String contact() {
		return "admin/contact";
	}

	// ------------------------------处理--------------------------------------
	/**
	 * @param
	 * @return String
	 * @description 登录处理
	 */
	@RequestMapping("/loginAction")
	public String loginAction() {
		return "admin/index";
	}

	// ------------------------------ajax处理--------------------------------------
	/**
	 * @param
	 * @return Message
	 * @description 查询用户数量
	 */
	@GetMapping("/selectUserCount")
	@ResponseBody
	public Message selectUserCount() {
		// logger.info("进入selectUserCount");
		return Message.success().add("count", userService.selectUserCount());
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询文章数量
	 */
	@GetMapping("/selectArticleCount")
	@ResponseBody
	public Message selectArticleCount() {
		// logger.info("进入selectArticleCount");
		return Message.success().add("count", articleService.selectArticleCount());
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询评论数量
	 */
	@GetMapping("/selectCommentCount")
	@ResponseBody
	public Message selectCommentCount() {
		// logger.info("进入selectCommentCount");
		return Message.success().add("count", commentService.selectCommentCount());
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询留言数量
	 */
	@GetMapping("/selectMessageCount")
	@ResponseBody
	public Message selectMessageCount() {
		// logger.info("进入selectMessageCount");
		return Message.success().add("count", messageService.selectMessageCount());
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询所有用户
	 */
	@GetMapping("/selectAllUser/{pn}")
	@ResponseBody
	public Message selectAllUser(@PathVariable("pn") Integer pn) {
		// logger.info("进入selectAllUser");
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<User> users = userService.selectAllUser();
		PageInfo pageInfo = new PageInfo(users, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过userId查询用户
	 */
	@GetMapping("/selectUserById/{userId}")
	@ResponseBody
	public Message selectUserById(@PathVariable("userId") Integer userId, HttpServletRequest request) {
		// logger.info("进入selectUserById");
		// logger.info("ip地址:"+request.getRemoteAddr());
		User user = userService.selectUserById(userId);
		return Message.success().add("user", user);

	}

	/**
	 * @param
	 * @return Message
	 * @description 通过Id更新用户
	 */
	@PostMapping("/updateUserById")
	@ResponseBody
	public Message updateUserById(User user, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request,"avatar").split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			// logger.info(userAvatar);
			user.setUserAvatar(userAvatar);
		}
		userService.updateUserByUserId(user);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过ajax实时显示修改的头像
	 */
	@PostMapping("/showImgOnTime")
	@ResponseBody
	public Message showImgOnTime(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws UnsupportedEncodingException {
		String[] userAvatars = PhotoUtil.saveFile(file, request,"avatar").split("webapp");
		String userAvatar = userAvatars[1].replace("\\", "/");
		return Message.success().add("imgUrl", userAvatar);
	}
 
	/**
	 * @param
	 * @return Message
	 * @description 通过ajax实时显示修改的标签头像
	 */
	@PostMapping("/showImgOnTime1")
	@ResponseBody
	public Message showImgOnTime1(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws UnsupportedEncodingException {
		String[] userAvatars = PhotoUtil.saveFile(file, request,"tag").split("webapp");
		String userAvatar = userAvatars[1].replace("\\", "/");
        //logger.info(tagImage);
		return Message.success().add("imgUrl", userAvatar);
	}
	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除用户
	 */
	@GetMapping("/deleteUserById")
	@ResponseBody
	public Message deleteUserById(@RequestParam("userId") String userId) {
		List<Integer> ids = new ArrayList<>();
		if (userId.contains("-")) {
			String[] userIds = userId.split("-");
			for (String id : userIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(userId));
		}
		userService.deleteUserByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 新增用户
	 */
	@PostMapping("/addUser")
	@ResponseBody
	public Message addUser(User user, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request,"avatar").split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			user.setUserAvatar(userAvatar);
			// logger.info(userAvatar);
		}
		user.setUserRegisterTime(new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date()));
		userService.insertUser(user);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 查看所有文章
	 */
	@GetMapping("/selectAllArticle/{pn}")
	@ResponseBody
	public Message selectAllArticle(@PathVariable("pn") Integer pn,
			@RequestParam(name = "type", required = false, defaultValue = "0") Integer type) {
		List<Article> articles = null;
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		if (type == 1) {//有效文章
			articles = articleService.selectAllArticleWithStatus();
		}
		if (type == 2) {//无效文章
			articles = articleService.selectAllArticleWithoutStatus();
		}
		if (type == 3) {//置顶文章
			articles = articleService.selectAllArticleWithOrder();
		}
		if (type == 4) {//未置顶文章
			articles = articleService.selectAllArticleWithoutOrder();
		}
		if (type == 0) {
			logger.info("type==0方法被调用");
			articles = articleService.selectAllArticle();
		}
		if (articles == null) {
			logger.info("articles==null方法被调用");
			articles = articleService.selectAllArticle();
		}
		PageInfo pageInfo = new PageInfo(articles, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo).add("type",type);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id查询文章
	 */
	@GetMapping("/selectArticleById/{articleId}")
	@ResponseBody
	public Message selectArticleById(@PathVariable("articleId") Integer articleId) {
		Article article = articleService.selectArticleById(articleId);
		return Message.success().add("article", article);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id修改文章
	 */
	@PostMapping("/updateArticleById")
	@ResponseBody
	public Message updateArticleById(@RequestParam Integer articleId, Article article) {
		// logger.info("进入到updateArticleById的方法");
		articleService.updateArticleById(article);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除文章
	 */
	@GetMapping("/deleteArticleById")
	@ResponseBody
	public Message deleteArticleById(@RequestParam("articleId") String articleId) {
		// logger.info("进入到deleteArticleById");
		List<Integer> ids = new ArrayList<>();
		if (articleId.contains("-")) {
			String[] articleIds = articleId.split("-");
			for (String id : articleIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(articleId));
		}
		articleService.deleteArticleByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询所有的评论
	 */
	@GetMapping("/selectAllComment/{pn}")
	@ResponseBody
	public Message selectAllComment(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Comment> comments = commentService.selectAllComment();
		PageInfo pageInfo = new PageInfo(comments, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除评论
	 */
	@GetMapping("/deleteCommentById")
	@ResponseBody
	public Message deleteCommentById(@RequestParam("commentId") String commentId) {
		List<Integer> ids = new ArrayList<>();
		if (commentId.contains("-")) {
			String[] commentIds = commentId.split("-");
			for (String id : commentIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(commentId));
		}
		commentService.deleteCommentByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询所有的留言
	 */
	@GetMapping("/selectAllMessage/{pn}")
	@ResponseBody
	public Message selectAllMessage(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Message> messages = messageService.selectAllMessage();
		PageInfo pageInfo = new PageInfo(messages, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除留言
	 */
	@GetMapping("/deleteMessageById")
	@ResponseBody
	public Message deleteMessageById(@RequestParam("messageId") String messageId) {
		List<Integer> ids = new ArrayList<>();
		if (messageId.contains("-")) {
			String[] messageIds = messageId.split("-");
			for (String id : messageIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(messageId));
		}
		messageService.deleteMessageByBatchById(ids);
		return Message.success();
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
	 * @return Message
	 * @description 修改个人信息
	 */
	@PostMapping("/updateMe")
	@ResponseBody
	public Message updateMe(Me me, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request,"avatar").split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			// logger.info(userAvatar);
			me.setAvatar(userAvatar);
		}
		me.setId(1);
		meService.updateMe(me);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 查询所有的联系人
	 */
	@GetMapping("/selectAllContact/{pn}")
	@ResponseBody
	public Message selectAllContact(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Contact> contacts = contactService.selectAllContact();
		PageInfo pageInfo = new PageInfo(contacts, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除联系人
	 */
	@GetMapping("/deleteContactById")
	@ResponseBody
	public Message deleteContactById(@RequestParam("id") String id) {
		List<Integer> ids = new ArrayList<>();
		if (id.contains("-")) {
			String[] contactIds = id.split("-");
			for (String id1 : contactIds) {
				ids.add(Integer.parseInt(id1));
			}
		} else {
			ids.add(Integer.parseInt(id));
		}
		contactService.deleteContactByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量修改联系人信息已读
	 */
	@GetMapping("/updateContactById")
	@ResponseBody
	public Message updateContactById(@RequestParam("id") String id) {
		List<Integer> ids = new ArrayList<>();
		if (id.contains("-")) {
			String[] contactIds = id.split("-");
			for (String id1 : contactIds) {
				ids.add(Integer.parseInt(id1));
			}
		} else {
			ids.add(Integer.parseInt(id));
		}
		contactService.updateContactByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 将全部的信息设为已读
	 */
	@GetMapping("/updateAllContact")
	@ResponseBody
	public Message updateAllContact() {
		contactService.updateAllContact();
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 将全部的信息设为已读
	 */
	@GetMapping("/selectNewContactCount")
	@ResponseBody
	public Message selectNewContactCount() {
		Integer newContactCount = contactService.selectNewContactCount();
		return Message.success().add("newContactCount", newContactCount);
	}

	/**
	 * @param
	 * @return Message
	 * @description 查看所有分类
	 */
	@GetMapping("/selectAllTag/{pn}")
	@ResponseBody
	public Message selectAllTag(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Tag> tags = tagService.selectAllTag();
		PageInfo pageInfo = new PageInfo(tags, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除标签
	 */
	@GetMapping("/deleteTagById")
	@ResponseBody
	public Message deleteTagById(@RequestParam("tagId") String tagId) {
		List<Integer> ids = new ArrayList<>();
		if (tagId.contains("-")) {
			String[] tagIds = tagId.split("-");
			for (String id : tagIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(tagId));
		}
		tagService.deleteTagByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id查询标签
	 */
	@GetMapping("/selectTagById/{tagId}")
	@ResponseBody
	public Message selectTagById(@PathVariable("tagId") Integer tagId) {
		Tag tag = tagService.selectTagById(tagId);
		return Message.success().add("tag", tag);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过Id更新用户
	 */
	@PostMapping("/updateTagById")
	@ResponseBody
	public Message updateTagById(Tag tag, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request,"tag").split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			// logger.info(userAvatar);
			tag.setTagImage(userAvatar);
			
		}
		tagService.updateTagById(tag);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 新增用户
	 */
	@PostMapping("/addTag")
	@ResponseBody
	public Message addTag(Tag tag, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request,"avatar").split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			String tagImage=userAvatar.replaceAll("avatar","tag");
			tag.setTagImage(tagImage);
			// logger.info(userAvatar);
		}
		tagService.insertTag(tag);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id单个和批量删除分类
	 */
	@GetMapping("/deleteCategoryById")
	@ResponseBody
	public Message deleteCategoryById(@RequestParam("categoryId") String categoryId) {
		List<Integer> ids = new ArrayList<>();
		if (categoryId.contains("-")) {
			String[] categoryIds = categoryId.split("-");
			for (String id : categoryIds) {
				ids.add(Integer.parseInt(id));
			}
		} else {
			ids.add(Integer.parseInt(categoryId));
		}
		categoryService.deleteCategoryByBatchById(ids);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id查询分类
	 */
	@GetMapping("/selectCategoryById/{categoryId}")
	@ResponseBody
	public Message selectCategoryById(@PathVariable("categoryId") Integer categoryId) {
		Category category = categoryService.selectCategoryById(categoryId);
		return Message.success().add("category", category);
	}

	/**
	 * @param
	 * @return Message
	 * @description 通过id修改分类
	 */
	@PostMapping("/updateCategoryById")
	@ResponseBody
	public Message updateCategoryById(@RequestParam Integer categoryId, Category category) {
		// logger.info("进入到updateCategoryById的方法");
		// logger.info(category.toString());
		categoryService.updateCategoryById(category);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 新增分类
	 */
	@PostMapping("/addCategory")
	@ResponseBody
	public Message addCategory(Category category) {
		categoryService.insertCategory(category);
		return Message.success();
	}

	/**
	 * @param
	 * @return Message
	 * @description 查看所有分类
	 */
	@GetMapping("/selectAllCategory/{pn}")
	@ResponseBody
	public Message selectAllCategory(@PathVariable("pn") Integer pn) {
		PageHelper.startPage(pn, 5);// 后面紧跟的查询为分页查询
		List<Category> categorys = categoryService.selectAllCategory();
		PageInfo pageInfo = new PageInfo(categorys, 5);// 用pageInfo封装然后交给页面
		return Message.success().add("pageInfo", pageInfo);
	}

}
