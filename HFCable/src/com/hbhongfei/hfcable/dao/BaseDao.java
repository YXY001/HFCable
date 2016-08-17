package com.hbhongfei.hfcable.dao;

import java.util.List;
import java.util.Map;

//基础Dao
//使用泛型与接口
public interface BaseDao <T>{

	public int save(T t);//保存实体类
	
	public void saveOrUpdate(T t);//保存或修改
	
	public int update(T t);//修改
	
	public int update(String hql,Map<String,Object> params);//修改2
	
	public void delete(T t);//删除1
	
	public int delete(String hql,Map<String,Object> params);//根据id进行删除
	
	public T getOneByHql(String hql,Map<String,Object> params);//根据hql语句查询一条数据

	public T getOneByEntity(Class<T> t,int id);//根据实体查询一条数据
	
	public T getOneByEntity(int id);//根据实体查询一条数据
	
	public List<T> getBySql(String hql, Map<String, Object> params);//根据hql语句查询多条数据
	
	public List<T> getAll(String hql);//获取所有
	
	public List<T> getTen(String hql,Map<String, Object> params);//获取10条
	
	public int getCount(String hql);//通过hql语句得到想要得到的行数
	

}

