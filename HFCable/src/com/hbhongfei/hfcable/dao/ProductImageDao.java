package com.hbhongfei.hfcable.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.ProductImage;



public interface ProductImageDao {
	//删除数据
	public void delete(ProductImage productImage);
	
	public int deleteById(int id);

	public ProductImage getProdectById(int id);
	
	//更新数据
	public void update(ProductImage productImage);
	//根据id更新
	public int updateById(int id,String productImage);
	//根据种类id查找产品
	public List<ProductImage> findByTypeId(int id);
}
