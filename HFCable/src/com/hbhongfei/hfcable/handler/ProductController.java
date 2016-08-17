package com.hbhongfei.hfcable.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hbhongfei.hfcable.dao.ProdectDao;
import com.hbhongfei.hfcable.entities.Product;
import com.hbhongfei.hfcable.entities.Type;
import com.hbhongfei.hfcable.service.ProdectService;
import com.hbhongfei.hfcable.service.TypeService;


@RequestMapping("/product")
@Controller
public class ProductController {
	@Autowired
	private  ProdectService prodectService;
	@Autowired
	private  TypeService typeService;
	
	
	/*@RequestMapping(value="/save",method=RequestMethod.POST)
	private String saveOrUpdate(
			@RequestParam(value = "prodectName") String prodectName,
			@RequestParam(value = "productImg",required = false) MultipartFile file,
			@RequestParam(value = "id") int typeid,
			@RequestParam(value = "price") Double price,
			@RequestParam(value = "specifications") String specifications,
			@RequestParam(value = "model") String model,
			@RequestParam(value = "lineCoreType") String lineCoreType,
			@RequestParam(value = "detail") String detail,
			HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
			  //获得物理路径webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");  
		    String path="";
			if(!file.isEmpty()){  
	            //生成uuid作为文件名称  
	            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
	            //获得文件类型（可以判断如果不是图片，禁止上传）  
	            String contentType=file.getContentType();  //图片类型
	            System.out.println(contentType);
	            //判断是否为图片类型
	            if (contentType.substring(0, contentType.indexOf("/")).equals("image")) {
	            	 //获得文件后缀名称  
		            String imageName=contentType.substring(contentType.indexOf("/")+1);  
		            path="/images/"+uuid+"."+imageName;  
		            file.transferTo(new File(pathRoot+path));  
		        	System.out.println(path+"sssssssssssssssss");
					Product product=new Product();
					Type type=typeService.getType(typeid);
					product.setProdectName(prodectName);
					product.setProductImg(path);
					product.setType(type);
					product.setPrice(price);
					product.setDetail(detail);
					product.setLineCoreType(lineCoreType);
					product.setSpecifications(specifications);
					product.setModel(model);
					//保存信息
					int result=prodectService.saveOrUpdate(product);
					if(result>0){
						return "redirect:/product/get";
					}else{
						return "redirect:/product/toProduct";
					}
					
	            }else{
	            	session.setAttribute("error", "上传文件格式不正确");
					return "redirect:/product/toProduct";
	            }
	        }else{
	        	
				return "redirect:/product/toProduct";
	        }
		
	} */
	
	/**
	 * 保存多张图片
	 * @param prodectName
	 * @param file
	 * @param typeid
	 * @param price
	 * @param specifications
	 * @param model
	 * @param lineCoreType
	 * @param detail
	 * @param request
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	private String saveOrUpdate(
			@RequestParam(value = "prodectName") String prodectName,
			@RequestParam(value = "id") int typeid,
			@RequestParam(value = "price") Double price,
			@RequestParam(value = "specifications") String specifications,
			@RequestParam(value = "model") String model,
			@RequestParam(value = "lineCoreType") String lineCoreType,
			@RequestParam(value = "detail") String detail
			) throws IllegalStateException, IOException{
					Product product=new Product();
					Type type=typeService.getType(typeid);
					product.setProdectName(prodectName);
			
					product.setType(type);
					product.setPrice(price);
					product.setDetail(detail);
					product.setLineCoreType(lineCoreType);
					product.setSpecifications(specifications);
					product.setModel(model);
					//保存信息
					int result=prodectService.saveOrUpdate(product);
					if(result>0){
						return "redirect:/product/get";
					}else{
						return "redirect:/product/toProduct";
					}
	         
	           
	            
	            
	       
		
	} 
	
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	private String getAll(Map<String, Object> map){
		List<Product> list=prodectService.getAll();
		if(!list.isEmpty()){
			map.put("productList", list);
			return "product_list";
		}else {
			//提示消息
			return "product_list";
		}
		
	} 
	
	@RequestMapping(value="/toProduct",method=RequestMethod.GET)
	private String changeToProduct(Map<String,Object> map){
		List<Type> list_type=typeService.getAll();
	
		map.put("typeList", list_type);
		return "product";
	} 
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	private String deleteById(@RequestParam(value = "id") int id){
		int i=prodectService.deleteById(id);
		if(i>0){
			return "redirect:/product/get";
		}else {
			//提示消息
			return "redirect:/product/get";
		}
		
	} 
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateById(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "prodectName") String prodectName,
			@RequestParam(value = "typeid") int typeid,
			@RequestParam(value = "price") Double price,
			@RequestParam(value = "specifications") String specifications,
			@RequestParam(value = "model") String model,
			@RequestParam(value = "lineCoreType") String lineCoreType,
			@RequestParam(value = "detail") String detail,
			HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
			Product product=prodectService.getProduct(id);
			Type type=typeService.getType(typeid);
			product.setProdectName(prodectName);
			product.setType(type);
			product.setPrice(price);
			product.setDetail(detail);
			product.setLineCoreType(lineCoreType);
			product.setSpecifications(specifications);
			product.setModel(model);
			int result=prodectService.updateByid(id, prodectName,price,specifications,model,
					lineCoreType,detail,typeid);
				if(result>0){
					return "redirect:/product/get";
				}else{
					//提示更新失败信息
					return "update_product";
				}
	} 
	/**
	 * 跳转到更新页面，将产品和种类信息返回
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/toUpdate",method=RequestMethod.GET)
	private String toUpdate(@RequestParam(value = "id") int id,Map<String,Object> map){
		Product product=prodectService.getProduct(id);
		List<Type> list_type=typeService.getAll();
		map.put("typeList", list_type);
		map.put("product", product);
		return "update_product";
	} 
}
