package com.hbhongfei.hfcable.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.ProdectDao;
import com.hbhongfei.hfcable.dao.ProductImageDao;
import com.hbhongfei.hfcable.dao.TypeDao;
import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.ProductImage;
import com.hbhongfei.hfcable.entities.Type;
@Repository
@Transactional
public class ProductImageDaoImpo implements ProductImageDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {// �������ƺ���
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void delete(ProductImage product) {
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
	public int updateById(int id,String productImage) {
		// TODO Auto-generated method stub
		String hql="UPDATE ProductImage p SET image=? WHERE id=?";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter(0, productImage);
		query.setParameter(1, id);
		return query.executeUpdate();
	}
	@Override
	public ProductImage getProdectById(int id) {
		// TODO Auto-generated method stub
		ProductImage product=(ProductImage) this.getCurrentSession().get(ProductImage.class, id);
		return product;
	}
	@Override
	public void update(ProductImage product) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(product);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductImage> findByTypeId(int id) {
		// TODO Auto-generated method stub
		String hql="from Product p where p.type.id=?";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		return query.list();
	}
	

}
