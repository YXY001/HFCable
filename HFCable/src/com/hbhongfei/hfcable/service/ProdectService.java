package com.hbhongfei.hfcable.service;


import java.util.List;

import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.ProductImage;
import com.hbhongfei.hfcable.entities.Type;
	
	public interface ProdectService {
		/**
		 * 保存产品信息
		 * @author dell1
		 *
		 */
		public int  saveOrUpdate(Product product);
		public List<Product> getAll();
		public int deleteById(int id);
		public int updateByid(int id,String productName,Double price,
				String specifications,String model,String lineCoreType,
				String detail,int typeid);
		public Product getProduct(int id);
		public void  update(Product product);
		//根据种类id查找是否关联产品
		public List<Product> findByTypeId(int id);
	}
	

