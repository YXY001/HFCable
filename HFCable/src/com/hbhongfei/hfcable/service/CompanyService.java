package com.hbhongfei.hfcable.service;

import java.util.List;

import com.hbhongfei.hfcable.entities.Company;

public interface CompanyService {
	public void saveOrUpdate(Company company); // ���湫˾��Ϣ

	public int update(Company company);// ����

	public int update(String name, String logo, String description, String productIntroduction, String address,
			String telephone,Integer zipCode,String email);// ���¹�˾����

	
	public int updateLogo(String logo);//����logo
	
	public List<Company> company_list();// ��˾��Ϣ

	public Company seleCom(Integer id);// ��ѯһ��

	public int delete(Integer id);// ����id����ɾ����˾��Ϣ
}
