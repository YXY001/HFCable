package com.hbhongfei.hfcable.service;

import java.util.List;

import com.hbhongfei.hfcable.entities.Company;

public interface CompanyService {
	public void saveOrUpdate(Company company); // 保存公司信息

	public int update(Company company);// 更新

	public int update(String name, String logo, String description, String productIntroduction, String address,
			String telephone,Integer zipCode,String email);// 更新公司名称

	
	public int updateLogo(String logo);//更新logo
	
	public List<Company> company_list();// 公司信息

	public Company seleCom(Integer id);// 查询一个

	public int delete(Integer id);// 根据id进行删除公司信息
}
