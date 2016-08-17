package com.hbhongfei.hfcable.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;
import com.hbhongfei.hfcable.dao.ProdectDao;
import com.hbhongfei.hfcable.dao.ProductImageDao;
import com.hbhongfei.hfcable.dao.TypeDao;
import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.ProductImage;
import com.hbhongfei.hfcable.entities.Type;
import com.hbhongfei.hfcable.service.ProdectImageService;
import com.hbhongfei.hfcable.service.ProdectService;
import com.hbhongfei.hfcable.service.TypeService;
import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;
@Service
@Transactional
public class ProdectImageServiceImpl implements ProdectImageService {
	@Resource
	private BaseDao<ProductImage> baseDao;
	@Resource
	private ProductImageDao productImageDao;
	@Override
	public int saveOrUpdate(ProductImage product) {
		// TODO Auto-generated method stub
		System.out.println(product.toString()+"00000");
	
		return baseDao.save(product);
	}
	@Override
	public List<ProductImage> getAll(){
		String hql="from ProductImage p";
		List<ProductImage> list=baseDao.getAll(hql);
		return list;
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return productImageDao.deleteById(id);
	}
	@Override
	public int updateByid(int id,String productImage) {

		// TODO Auto-generated method stub
		int i=productImageDao.updateById(id,productImage);
		return i;
	}
	
	@Override
	public ProductImage getProduct(int id) {
		// TODO Auto-generated method stub
		return productImageDao.getProdectById(id);
	}
	@Override
	public void update(ProductImage product) {
		// TODO Auto-generated method stub
		productImageDao.update(product);
	}
	@Override
	public List<ProductImage> findByTypeId(int id) {
		// TODO Auto-generated method stub
		return productImageDao.findByTypeId(id);
	}

}
