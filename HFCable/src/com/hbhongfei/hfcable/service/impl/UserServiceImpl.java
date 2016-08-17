package com.hbhongfei.hfcable.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;
import com.hbhongfei.hfcable.entities.User;
import com.hbhongfei.hfcable.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDao<User> baseDao;
	
	@Override
	public List<User> seleUser() {
		// TODO Auto-generated method stub
		String hql = "from User";
		ArrayList<User> list = (ArrayList<User>) baseDao.getAll(hql);
		return list;
	}

	@Override
	public User checkUser(String userName, String password) {
		String hql = "from User u where u.phoneNumber=:name and u.password=:pwd";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", userName);
		params.put("pwd", password);
		return (User) baseDao.getOneByHql(hql, params);
	}

	@Override
	public void save(User user) {
		baseDao.saveOrUpdate(user);
	}


}
