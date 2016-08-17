package com.hbhongfei.hfcable.dao;

import org.springframework.stereotype.Repository;

import com.hbhongfei.hfcable.entities.Type;


public interface TypeDao {
	//删除数据
	public void delete(Type type);
	
	public int deleteById(int id);

	public Type getTypeById(int id);
	public int updateById(int id, String typeName);
}
