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
import com.hbhongfei.hfcable.service.ProdectService;
import com.hbhongfei.hfcable.service.TypeService;
import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;
@Service
@Transactional
public class ProdectServiceImpl implements ProdectService {
	@Resource
	private BaseDao<Product> baseDao;
	@Resource
	private ProdectDao prodectDao;
	@Override
	public int saveOrUpdate(Product productImage) {
		// TODO Auto-generated method stub

	
		return baseDao.save(productImage);
	}
	@Override
	public List<Product> getAll(){
		String hql="from Product p";
		List<Product> list=baseDao.getAll(hql);
		return list;
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return prodectDao.deleteById(id);
	}
	@Override
	public int updateByid(int id,String productName,Double price,
			String specifications,String model,String lineCoreType,
			String detail,int typeid) {

		// TODO Auto-generated method stub
		int i=prodectDao.updateById(id,productName,price,specifications,model,lineCoreType,detail,typeid);
//		System.out.println(typeName);
		return i;
	}
	
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return prodectDao.getProdectById(id);
	}
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		prodectDao.update(product);
	}
	@Override
	public List<Product> findByTypeId(int id) {
		// TODO Auto-generated method stub
		return prodectDao.findByTypeId(id);
	}

}
