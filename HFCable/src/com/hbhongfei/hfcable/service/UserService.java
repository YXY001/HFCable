package com.hbhongfei.hfcable.service;

import java.util.List;

import com.hbhongfei.hfcable.entities.User;

public interface UserService {
	public List<User> seleUser();//查询所有用户
	public User checkUser(String userName,String password);//登录
	
	public void save(User user);//添加用户
}
