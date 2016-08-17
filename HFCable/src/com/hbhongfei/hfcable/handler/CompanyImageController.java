package com.hbhongfei.hfcable.handler;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hbhongfei.hfcable.entities.Companyimage;
import com.hbhongfei.hfcable.service.CompanyImageService;

@RequestMapping("/companyImage")
@Controller
public class CompanyImageController {

	@Autowired
	private CompanyImageService companyImageService;

	/**
	 * 跳转到公司图片列表界面，并展现公司图片
	 * 
	 * @param map
	 *            存储公司图片信息
	 * @param session
	 *            存储error信息
	 * @return 公司图片列表界面
	 */
	@RequestMapping("/list")
	public String list(Map<String, Object> map, HttpSession session) {
		/*map.put("companyimage", companyImageService.list());*/
		session.setAttribute("companyimage", companyImageService.list());
		session.setAttribute("error", null);
		return "company_images";
	}

	/**
	 * 跳转到添加公司图片界面
	 * 
	 * @param map
	 *            公司图图片类
	 * @return 添加公司图片界面
	 */
	@RequestMapping("/add")
	public String add(Map<String, Object> map) {
		map.put("companyimage", new Companyimage());
		return "company_image_add";
	}

	/**
	 * 保存公司图片信息，并根据不同的结果跳转到不同的界面
	 * 
	 * @param companyimage
	 *            公司图片信息
	 * @param file
	 *            公司图片
	 * @param request
	 *            利用request获取当前项目运行路径
	 * @param session
	 *            利用session存储error信息
	 * @return 如果保存成功跳转到公司图片列表界面，如果没有成功，则跳转到添加公司图片界面
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Companyimage companyimage, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		// 获取项目运行路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path = "";
		// for (MultipartFile mf : files) {
		if (!file.isEmpty()) {
			// 利用uuid保存图片名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获取文件类型
			String contentType = file.getContentType(); // image/jpeg
			if (contentType.substring(0, contentType.indexOf("/")).equals("image")) {
				// 获取图片的后缀名
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				path = "/companyImage/" + uuid + "." + imageName;
				file.transferTo(new File(pathRoot + path));
				companyimage.setImage(path);
				companyImageService.save(companyimage);
				return "redirect:/companyImage/list";
			} else {
				session.setAttribute("error", "文件格式不正确，请重新选择");
				return "redirect:/companyImage/add";
			}
		} else {
			session.setAttribute("error", "没有选择文件");
			return "redirect:/companyImage/add";
		}
	}

	/**
	 * 删除公司图片，并跳转到公司图片列表界面
	 * 
	 * @param id
	 *            公司图片id
	 * @return 公司图片列表界面
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id) {
		companyImageService.delete(id);
		return "redirect:/companyImage/list";
	}

}
