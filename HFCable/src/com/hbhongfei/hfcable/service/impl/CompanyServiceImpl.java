package com.hbhongfei.hfcable.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;
import com.hbhongfei.hfcable.entities.Company;
import com.hbhongfei.hfcable.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Resource
	private BaseDao<Company> baseDao;

	@Override
	public void saveOrUpdate(Company company) {
		baseDao.saveOrUpdate(company);
	}

	@Override
	public List<Company> company_list() {
		String hql = "from Company";
		ArrayList<Company> companys = (ArrayList<Company>) baseDao.getAll(hql);
		if (companys != null) {
			return companys;
		}
		return null;
	}

	@Override
	public Company seleCom(Integer id) {
		String hql = "from Company c where c.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return (Company) baseDao.getOneByHql(hql, params);
	}

	@Override
	public int delete(Integer id) {
		String hql = "delete Company c where c.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return baseDao.delete(hql, params);
	}

	@Override
	public int update(Company company) {
		return baseDao.update(company);
	}

	@Override
	public int update(String name, String logo, String description, String productIntroduction, String address,
			String telephone, Integer zipCode, String email) {
		String hql = "update Company c set c.companyName=:name,c.logo=:logo,c.description=:description,c.productIntroduction=:productIntroduction,c.address=:address,c.telephone=:telephone,c.zipCode=:zipCode,c.email=:email";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("logo", logo);
		params.put("description", description);
		params.put("productIntroduction", productIntroduction);
		params.put("address", address);
		params.put("telephone", telephone);
		params.put("zipCode", zipCode);
		params.put("email", email);
		return baseDao.update(hql, params);
	}

	@Override
	public int updateLogo(String logo) {
		String hql = "update Company c set c.logo=:logo";
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("logo", logo);
	return baseDao.update(hql, params);
	}

}
