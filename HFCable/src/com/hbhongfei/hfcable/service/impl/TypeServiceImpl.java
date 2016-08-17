package com.hbhongfei.hfcable.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;
import com.hbhongfei.hfcable.dao.TypeDao;
import com.hbhongfei.hfcable.entities.Type;
import com.hbhongfei.hfcable.service.TypeService;
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Resource
	private BaseDao<Type> baseDao;
	@Resource
	private TypeDao typeDao;
	@Override
	public int saveOrUpdate(Type type) {
		// TODO Auto-generated method stub
		return baseDao.save(type);
	}
	@Override
	public List<Type> getAll(){
		String hql="from Type t";
		List<Type> list=baseDao.getAll(hql);
		return list;
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return typeDao.deleteById(id);
	}
	@Override
	public int updateByid(int id,String typeName) {
		// TODO Auto-generated method stub
		
		return typeDao.updateById(id,typeName);
	}
	
	@Override
	public Type getType(int id) {
		// TODO Auto-generated method stub
		return typeDao.getTypeById(id);
	}

}
