package com.hbhongfei.hfcable.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.ProdectDao;
import com.hbhongfei.hfcable.dao.TypeDao;
import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.Type;
@Repository
@Transactional
public class ProdectDaoImpo implements ProdectDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {// �������ƺ���
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(product);
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		String hql="delete Product p where id=?";
		return this.getCurrentSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}
	
	@Override
	public int updateById(int id,String productName,Double price,
			String specifications,String model,String lineCoreType,
			String detail,int typeid) {
		// TODO Auto-generated method stub
		String hql="UPDATE Product p SET productName=?,p.type.id=?,price=?,"
				+ "specifications=?,model=?,lineCoreType=?,detail=? WHERE id=?";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter(0, productName);
		query.setParameter(1, typeid);
		query.setParameter(2, price);
		query.setParameter(3, specifications);
		query.setParameter(4, model);
		query.setParameter(5, lineCoreType);
		query.setParameter(6, detail);
		query.setParameter(7, id);
		return query.executeUpdate();
	}
	@Override
	public Product getProdectById(int id) {
		// TODO Auto-generated method stub
		Product product=(Product) this.getCurrentSession().get(Product.class, id);
		return product;
	}
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(product);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByTypeId(int id) {
		// TODO Auto-generated method stub
		String hql="from Product p where p.type.id=?";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		return query.list();
	}
	

}
