package com.hbhongfei.hfcable.dao;

import java.util.List;
import java.util.Map;

//����Dao
//ʹ�÷�����ӿ�
public interface BaseDao <T>{

	public int save(T t);//����ʵ����
	
	public void saveOrUpdate(T t);//������޸�
	
	public int update(T t);//�޸�
	
	public int update(String hql,Map<String,Object> params);//�޸�2
	
	public void delete(T t);//ɾ��1
	
	public int delete(String hql,Map<String,Object> params);//����id����ɾ��
	
	public T getOneByHql(String hql,Map<String,Object> params);//����hql����ѯһ������

	public T getOneByEntity(Class<T> t,int id);//����ʵ���ѯһ������
	
	public T getOneByEntity(int id);//����ʵ���ѯһ������
	
	public List<T> getBySql(String hql, Map<String, Object> params);//����hql����ѯ��������
	
	public List<T> getAll(String hql);//��ȡ����
	
	public List<T> getTen(String hql,Map<String, Object> params);//��ȡ10��
	
	public int getCount(String hql);//ͨ��hql���õ���Ҫ�õ�������
	

}

