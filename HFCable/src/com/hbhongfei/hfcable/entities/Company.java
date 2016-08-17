package com.hbhongfei.hfcable.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", catalog = "hfcable")
public class Company implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String logo;
	private String companyName;
	private String description;
	private String productIntroduction;
	private String address;
	private String telephone;
	private Integer zipCode;
	private String email;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(String logo, String companyName, String description,
			String productIntroduction, String address, String telephone,
			Integer zipCode, String email) {
		this.logo = logo;
		this.companyName = companyName;
		this.description = description;
		this.productIntroduction = productIntroduction;
		this.address = address;
		this.telephone = telephone;
		this.zipCode = zipCode;
		this.email = email;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "logo", nullable = false, length = 200)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "companyName", nullable = false, length = 200)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "description", nullable = false, length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "productIntroduction", nullable = false, length = 2000)
	public String getProductIntroduction() {
		return this.productIntroduction;
	}

	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}

	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "telephone", nullable = false)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "zipCode", nullable = false)
	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "email", nullable = false, length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", logo=" + logo + ", companyName=" + companyName + ", description=" + description
				+ ", productIntroduction=" + productIntroduction + ", address=" + address + ", telephone=" + telephone
				+ ", zipCode=" + zipCode + ", email=" + email + "]";
	}

}