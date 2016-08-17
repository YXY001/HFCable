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
import com.hbhongfei.hfcable.entities.ProductImage;
import com.hbhongfei.hfcable.entities.Type;
import com.hbhongfei.hfcable.service.ProdectImageService;
import com.hbhongfei.hfcable.service.ProdectService;
import com.hbhongfei.hfcable.service.TypeService;


@RequestMapping("/productImage")
@Controller
public class ProductImageController {
	@Autowired
	private  ProdectImageService prodectImageService;
	@Autowired
	private  ProdectService prodectService;
	/**
	 * 跳转到添加产品图片界面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/toSave",method=RequestMethod.GET)
	private String toSave(
			@RequestParam(value = "id") int  id,
			Map<String, Object> map){
			System.out.println(id);
			map.put("productId", id);
			return "productImg";

	} 
	/**
	 * 保存多张图片
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	private String saveOrUpdate(
			@RequestParam(value = "id") int productId,
			@RequestParam(value = "productImg",required = false) MultipartFile[] file,
			HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
			
			//获得物理路径webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");  
		    String path="";
		    List<String> listImagePath=new ArrayList<String>();  
		    for (MultipartFile mf : file) {  
			if(!mf.isEmpty()){
	            //生成uuid作为文件名称  
	            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
	            //获得文件类型（可以判断如果不是图片，禁止上传）  
	            String contentType=mf.getContentType();  //图片类型
	    
	            //判断是否为图片类型
	            if (contentType.substring(0, contentType.indexOf("/")).equals("image")) {
	            	 //获得文件后缀名称  
		            String imageName=contentType.substring(contentType.indexOf("/")+1);  
		            path="/images/"+uuid+"."+imageName;  
		            mf.transferTo(new File(pathRoot+path));  
		        	System.out.println(path+"ssaaasss");
		        	listImagePath.add(path);  
					ProductImage productImage=new ProductImage();
					Product product=prodectService.getProduct(productId);
					productImage.setProduct(product);
					productImage.setImage(path);
					//保存信息
					prodectImageService.saveOrUpdate(productImage);
				
	            }else{
	            	session.setAttribute("error", "上传文件格式不正确");
					return "redirect:/productImage/toSave";
	            }
	        }else{
				return "redirect:/productImage/get";
	        }
		    }
		    return "redirect:/productImage/get";
		
	} 
	
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	private String getAll(Map<String, Object> map){
		List<ProductImage> list=prodectImageService.getAll();
		System.out.println(list.toString());
		if(!list.isEmpty()){
			map.put("productImgList", list);
			return "productImg_list";
		}else {
			//提示消息
			return "productImg_list";
		}
		
	} 
	
//	@RequestMapping(value="/toProduct",method=RequestMethod.GET)
//	private String changeToProduct(Map<String,Object> map){
//		List<Type> list_type=typeService.getAll();
//	
//		map.put("typeList", list_type);
//		return "product";
//	} 
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	private String deleteById(@RequestParam(value = "id") int id){
		int i=prodectImageService.deleteById(id);
		if(i>0){
			return "redirect:/productImage/get";
		}else {
			//提示消息
			return "redirect:/productImage/get";
		}
		
	} 
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	private String updateById(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "productImg",required = false) MultipartFile file,
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
		            System.out.println(path+"aaaaadddd");
					int result=prodectImageService.updateByid(id,path);
					if(result>0){
						return "redirect:/productImage/get";
					}else{
						//提示更新失败信息
						return "update_product";
					}
	          }else{
	        	  	return "redirect:/productImage/toUpdate";
	        	  }
			}else{
					//提示更新失败信息
					return "redirect:/productImage/get";
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
		ProductImage productImage=prodectImageService.getProduct(id);
		map.put("productImage", productImage);
		return "update_productImg";
	} 
}
