package com.hbhongfei.hfcable.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;

@Repository
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {
	// 自动注入方式
	T t;
	@Resource
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {// 返回自制函数
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int save(T t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(t);
		return 0;
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getOneByHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);

		if (params != null & !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}

		List<T> list = q.list();
		if (list != null & list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public T getOneByEntity(int id) {
		T t = null;
		@SuppressWarnings("unchecked")
		T q = (T) this.getCurrentSession().get(t.getClass(), id);

		return q;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getOneByEntity(Class<T> t, int id) {
		T o = (T) this.getCurrentSession().get(t, id);
		// T o2= (T) this.getCurrentSession().get((Class)t, id);
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBySql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null & !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}

		List<T> list = q.list();
		if (list != null & list.size() > 0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> list = q.list();
		return list;
	}

	@Override
	public int getCount(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);

		return (Integer) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getTen(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null & !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		q.setFirstResult(0);
		q.setMaxResults(11);
		List<T> list = q.list();
		if (list != null) {
			return list;
		}
		return null;
	}
	@Override
	public int delete(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null & !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		
		return q.executeUpdate();
	}
	@Override
	public int update(T t) {
		this.getCurrentSession().update(t);
		return 1;
	}
	@Override
	public int update(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null & !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}
}
