package com.hbhongfei.hfcable.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "hfcable")
public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Type type;
	private String productName;
//	private String productImg;
	private Double price;
	private String specifications;
	private String model;
	private String lineCoreType;
	private String detail;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Type type, String prodectName,
			Double price, String specifications, String model,
			String lineCoreType) {
		this.type = type;
		this.productName = prodectName;
		this.price = price;
		this.specifications = specifications;
		this.model = model;
		this.lineCoreType = lineCoreType;
	}

	/** full constructor */
	public Product(Type type, String prodectName,
			Double price, String specifications, String model,
			String lineCoreType, String detail) {
		this.type = type;
		this.productName = prodectName;
		this.price = price;
		this.specifications = specifications;
		this.model = model;
		this.lineCoreType = lineCoreType;
		this.detail = detail;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId", nullable = false)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "productName", nullable = false, length = 50)
	public String getProdectName() {
		return this.productName;
	}

	public void setProdectName(String prodectName) {
		this.productName = prodectName;
	}

//	@Column(name = "productImg", nullable = false, length = 2000)
//	public String getProductImg() {
//		return this.productImg;
//	}
//
//	public void setProductImg(String productImg) {
//		this.productImg = productImg;
//	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "specifications", nullable = false, length = 50)
	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Column(name = "model", nullable = false, length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "lineCoreType", nullable = false, length = 50)
	public String getLineCoreType() {
		return this.lineCoreType;
	}

	public void setLineCoreType(String lineCoreType) {
		this.lineCoreType = lineCoreType;
	}

//	@Column(name = "", length = 2000)
//	public String getdetail() {
//		return this.detail;
//	}
//
//	public void setdetail(String detail) {
//		this.detail = detail;
//	}
	@Column(name = "detail",nullable = true, length = 2000)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", prodectName="
				+ productName  + ", price="
				+ price + ", specifications=" + specifications + ", model="
				+ model + ", lineCoreType=" + lineCoreType + ", detail="
				+ detail + "]";
	}

	

}