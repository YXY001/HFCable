package com.hbhongfei.hfcable.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hbhongfei.hfcable.entities.Company;
import com.hbhongfei.hfcable.service.CompanyService;

@RequestMapping("/company")
@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
	 * 跳转到公司界面
	 * 
	 * @param httpSession
	 *            利用session作用域存储公司信息和error信息
	 * @return 公司信息界面
	 */

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession httpSession) {
		httpSession.setAttribute("company", companyService.company_list());
		httpSession.setAttribute("error", null);
		// mapde的作用域相当于request，
		// map.put("company", companyService.company_list());
		return "company_list";
	}

	/**
	 * 跳转到添加公司界面
	 * 
	 * @param map
	 *            利用request作用域保存格式信息
	 * @return 公司信息添加界面
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> map) {
		map.put("company", new Company());
		return "company_add";
	}

	/**
	 * 进行保存格公司的基本信息和logo
	 * 
	 * @param company
	 *            公司信息
	 * @param file
	 *            logo
	 * @param request
	 *            利用request作用域获取当前项目的运行路径
	 * @param session
	 *            利用session保存error信息
	 * @return 如果保存成功则返回公司信息列表界面，如果没有成功，重定向到添加公司界面
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Company company, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if (!file.isEmpty()) {
			// 利用uuid进行给图片命名
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获取文件的类型，可用于判断图片类型
			String contentType = file.getContentType(); // image/jpeg或者image/png
			if (contentType.substring(0, contentType.indexOf("/")).equals("image")) {
				// 获取图片的后缀名
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				path = "/companyImage/" + uuid + "." + imageName;
				System.out.println(path);
				file.transferTo(new File(pathRoot + path));
				company.setLogo(path);
				companyService.saveOrUpdate(company);
				return "redirect:/company/list";
			} else {
				session.setAttribute("error", "文件格式不正确，请重新选择");
				return "redirect:/company/add";
			}
		} else {
			session.setAttribute("error", "没有选择文件");
			return "redirect:/company/add";
		}
	}

	/**
	 * 重定向到公司信息列表
	 * 
	 * @param id
	 *            公司id
	 * @return 公司信息列表
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Integer id) {
		companyService.delete(id);
		return "redirect:/company/list";
	}

	/**
	 * 跳转到更新公司名称界面
	 * 
	 * @param id
	 *            公司id
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司名称界面
	 */
	@RequestMapping(value = "/edit1/{id}")
	public String update1(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit1";
	}

	/**
	 * 跳转到更新公司logo界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司logo界面
	 */
	@RequestMapping(value = "/edit2")
	public String update2(Map<String, Object> map) {
		ArrayList<Company> companys = (ArrayList<Company>) companyService.company_list();
		Company company = companys.get(0);
		map.put("company", company);
		return "company_edit2";
	}

	/**
	 * 跳转到更新公司介绍界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司介绍界面
	 */
	@RequestMapping(value = "/edit3/{id}")
	public String update3(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit3";
	}

	/**
	 * 跳转到更新公司产品介绍界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司产品介绍界面
	 */
	@RequestMapping(value = "/edit4/{id}")
	public String update4(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit4";
	}

	/**
	 * 跳转到更新公司地址界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司地址界面
	 */
	@RequestMapping(value = "/edit5/{id}")
	public String update5(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit5";
	}

	/**
	 * 跳转到更新公司电话界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司电话界面
	 */
	@RequestMapping(value = "/edit6/{id}")
	public String update6(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit6";
	}

	/**
	 * 跳转到更新公司邮编界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司邮编界面
	 */
	@RequestMapping(value = "/edit7/{id}")
	public String update7(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit7";
	}

	/**
	 * 跳转到更新公司邮箱界面
	 * 
	 * @param map
	 *            利用request作用域来存储公司信息
	 * @return 更新公司邮箱界面
	 */
	@RequestMapping(value = "/edit8/{id}")
	public String update8(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
		Company company = companyService.seleCom(id);
		map.put("company", company);
		return "company_edit8";
	}

	/**
	 * 保存公司信息并且重定向到公司信息列表界面
	 * 
	 * @param c
	 *            公司信息
	 * @return 公司信息列表界面
	 */
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public String saveAndUpdate(Company c) {
		if (companyService.update(c.getCompanyName(), c.getLogo(), c.getDescription(), c.getProductIntroduction(), c.getAddress(), c.getTelephone(), c.getZipCode(), c.getEmail()) != 0) {
			companyService.update(c.getCompanyName(), c.getLogo(), c.getDescription(), c.getProductIntroduction(), c.getAddress(), c.getTelephone(), c.getZipCode(), c.getEmail());
			return "redirect:/company/list";
		}
		return null;
	}

	/**
	 * 保存格式logo并且跳转到不同的界面
	 * 
	 * @param file
	 *            公司logo图片文件
	 * @param request
	 *            利用request获取当前项目运行的环境路径
	 * @param session
	 *            利用session个作用域存储error值
	 * @return 当保存成功后跳转到公司信息列表界面，没有保存成功跳转到更新log界面
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save/logo", method = RequestMethod.POST)
	public String saveLogo(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if (!file.isEmpty()) {
			// 利用uui进行保存图片名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获取文件的类型
			String contentType = file.getContentType(); // image/jpeg或image/png
			if (contentType.substring(0, contentType.indexOf("/")).equals("image")) {
				// 获取图片的后缀名
				String imageName = contentType.substring(contentType.indexOf("/") + 1);
				path = "/companyImage/" + uuid + "." + imageName;
				file.transferTo(new File(pathRoot + path));
				companyService.updateLogo(path);
				return "redirect:/company/list";
			} else {
				session.setAttribute("error", "文件格式不正确，请重新选择");
				return "redirect:/company/edit2";
			}
		} else {
			session.setAttribute("error", "没有选择文件");
			return "redirect:/company/edit2";
		}
	}

	/**
	 * 回调时保存格式信息
	 * 
	 * @param id
	 *            公司id
	 * @param map
	 *            公司信息
	 */
	@ModelAttribute
	public void getValue(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("company", companyService.seleCom(id));
		}
	}

}
