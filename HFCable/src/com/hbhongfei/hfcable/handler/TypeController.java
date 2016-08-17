package com.hbhongfei.hfcable.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.Type;
import com.hbhongfei.hfcable.service.ProdectService;
import com.hbhongfei.hfcable.service.TypeService;


@RequestMapping("/type")
@Controller
public class TypeController {
	@Autowired
	private  TypeService typeService;
	@Autowired
	private  ProdectService prodectService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	private String saveOrUpdate(@RequestParam(value = "typeNmae") String typeNmae,
			Map<String, Object> map){
		Type type=new Type();
		type.setTypeName(typeNmae);

		int result=typeService.saveOrUpdate(type);
		if(result>0){
			return "redirect:/type/get";
		}else{
			//返回信息
			return "type";
		}
	} 
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	private String getAll(Map<String, Object> map){
		List<Type> list=typeService.getAll();
		System.out.println(list.toString());
		
			map.put("typeList", list);
			return "type_list";
		
	} 
	
	@RequestMapping(value="/toType",method=RequestMethod.GET)
	private String changeToType(){
//		typeService.getAll();
		return "type";
	} 

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	private String deleteById(@RequestParam(value = "id",required = false) int id){
		//根据种类查找是否管理产品
		List<Product> list_product=prodectService.findByTypeId(id);
		if(list_product.size()>0){
			//返回信息
			return "redirect:/type/get";
		}else{
			int i=typeService.deleteById(id);
			
			return "redirect:/type/get";
		}
	} 
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateById(@RequestParam(value = "id") int id,@RequestParam(value = "typeName") String typeName){
		
		int i=typeService.updateByid(id,typeName);
		if(i>0){
			return "redirect:/type/get";
		}else{
			//fanhuixiaoxi
		return "redirect:/type/toUpdate";
		}
	} 
	
	@RequestMapping(value="/toUpdate",method=RequestMethod.GET)
	private String toUpdate(@RequestParam(value = "id") int id,Map<String,Object> map){

		Type type=typeService.getType(id);
		
		map.put("type", type);
		return "update_type";
	} 
}
