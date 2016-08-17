package com.hbhongfei.hfcable.service;


import java.util.List;

import com.hbhongfei.hfcable.entities.Type;
	
	public interface TypeService {
		/**
		 * 保存产品种类
		 * @author dell1
		 *
		 */
		public int  saveOrUpdate(Type type);
		public List<Type> getAll();
		public int deleteById(int id);
		public int updateByid(int id,String typeName);
		public Type getType(int id);
	}
	

