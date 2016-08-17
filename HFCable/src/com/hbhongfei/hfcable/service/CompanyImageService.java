package com.hbhongfei.hfcable.service;

import java.util.ArrayList;

import com.hbhongfei.hfcable.entities.Companyimage;

public interface CompanyImageService {
	
	public ArrayList<Companyimage> list();
	
	public void save(Companyimage companyimage);
	
	public int delete(Integer id);

}
