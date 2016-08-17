package com.hbhongfei.hfcable.handler;



import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbhongfei.hfcable.entities.User;
import com.hbhongfei.hfcable.service.UserService;
import com.hbhongfei.hfcable.utils.Utils;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * web端用户登录 
	 * @param userName 手机号
	 * @param password 用户密码
	 * @param session 利用session作用域存储用户的用户名
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password,HttpSession session) {
		password = Utils.md5AndSha(password);
		System.out.println(userName+password);
		User user = userService.checkUser(userName, password);
		if(user!=null){
			System.out.println("登录成功");
			System.out.println("用户名为："+user.getNickName());
			session.setAttribute("CurrentUser", user.getNickName());
			return "product";
		}
		return "login_two";
	}

	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpSession session){
		session.setAttribute("CurrentUser",null);
		return "login_two";
	}
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public String save(User user){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		user.setId(uuid);
		String password = user.getPassword();
		user.setPassword(Utils.md5AndSha(password));
		user.setCreateTime(new Date());
		user.setHeadPortrait("111");
		user.setNickName("小黑");
		user.setSex("男");
		user.setUpdateTime(new Date());
		System.out.println(user);
		userService.save(user);
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/left")
	public String left(){
		return "left";
	}
	
	@RequestMapping("/right")
	public String right(){
		return "right";
	}
	@RequestMapping("/top")
	public String top(){
		return "top";
	}
}
