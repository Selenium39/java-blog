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
import com.wantao.bean.User;
import com.wantao.service.ArticleService;
import com.wantao.service.CommentService;
import com.wantao.service.MessageService;
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
			String[] userAvatars = PhotoUtil.saveFile(file, request).split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			// logger.info(userAvatar);
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
		String[] userAvatars = PhotoUtil.saveFile(file, request).split("webapp");
		String userAvatar = userAvatars[1].replace("\\", "/");
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
		if(userId.contains("-")) {
			String[] userIds=userId.split("-");
			for(String id:userIds) {
				ids.add(Integer.parseInt(id));
			}
		}else {
			ids.add(Integer.parseInt(userId));
		}
		userService.deleteUserByBatchById(ids);
		return Message.success();
	}
	
	@PostMapping("/addUser")
	@ResponseBody
	public Message addUser(User user, @RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		if (file.getSize() == 0) {// 注意这里不要使用file==null判断
			// logger.info(user.toString());
		} else {
			String[] userAvatars = PhotoUtil.saveFile(file, request).split("webapp");
			String userAvatar = userAvatars[1].replace("\\", "/");
			user.setUserAvatar(userAvatar);
			// logger.info(userAvatar);
		}
		user.setUserRegisterTime(new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss").format(new Date()));
		userService.insertUser(user);
		return Message.success();
	}

}
