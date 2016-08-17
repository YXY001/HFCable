package com.hbhongfei.hfcable.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hbhongfei.hfcable.dao.BaseDao;
import com.hbhongfei.hfcable.entities.Companyimage;
import com.hbhongfei.hfcable.service.CompanyImageService;

@Service
@Transactional
public class CompanyImageServiceImpl implements CompanyImageService {

	@Resource
	private BaseDao<Companyimage> baseDao;

	@Override
	public void save(Companyimage companyimage) {
		
		baseDao.save(companyimage);
		
	}

	@Override
	public ArrayList<Companyimage> list() {
		
		String hql = "from Companyimage";
		ArrayList<Companyimage> companyimages = (ArrayList<Companyimage>) baseDao.getAll(hql);
		if (companyimages != null) {
			return companyimages;
		}
		return null;
	}

	@Override
	public int delete(Integer id) {
		String hql = "delete Companyimage c where c.id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return baseDao.delete(hql, params);
		
	}
}
