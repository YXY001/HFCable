package com.hbhongfei.hfcable.service;


import java.util.List;

import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.ProductImage;
import com.hbhongfei.hfcable.entities.Type;
	
	public interface ProdectImageService {
		/**
		 * 保存产品信息
		 * @author dell1
		 *
		 */
		public int  saveOrUpdate(ProductImage product);
		public List<ProductImage> getAll();
		public int deleteById(int id);
		public int updateByid(int id,String productImg);
		public ProductImage getProduct(int id);
		public void  update(ProductImage product);
		//根据种类id查找是否关联产品
		public List<ProductImage> findByTypeId(int id);
	}
	

