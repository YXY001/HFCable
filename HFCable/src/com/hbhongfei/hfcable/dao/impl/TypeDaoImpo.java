package com.hbhongfei.hfcable.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.TypeDao;
import com.hbhongfei.hfcable.entities.Type;
@Repository
@Transactional
public class TypeDaoImpo implements TypeDao {
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {// �������ƺ���
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void delete(Type type) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(type);
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		String hql="delete Type t where id=?";
		return this.getCurrentSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}
	
	@Override
	public int updateById(int id,String typeName) {
		// TODO Auto-generated method stub
		String hql="UPDATE Type t SET typeName=? WHERE id=?";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter(0, typeName);
		query.setParameter(1, id);
		return query.executeUpdate();
	}
	@Override
	public Type getTypeById(int id) {
		// TODO Auto-generated method stub
		Type type=(Type) this.getCurrentSession().get(Type.class, id);
		return type;
	}
	

}
