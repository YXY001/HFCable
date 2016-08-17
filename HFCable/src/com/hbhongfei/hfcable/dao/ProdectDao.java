package com.hbhongfei.hfcable.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hbhongfei.hfcable.entities.Product;



public interface ProdectDao {
	//删除数据
	public void delete(Product product);
	
	public int deleteById(int id);

	public Product getProdectById(int id);
	
	//更新数据
	public void update(Product product);
	//根据id更新
	public int updateById(int id,String productName,Double price,
			String specifications,String model,String lineCoreType,
			String detail,int typeid);
	//根据种类id查找产品
	public List<Product> findByTypeId(int id);
}
