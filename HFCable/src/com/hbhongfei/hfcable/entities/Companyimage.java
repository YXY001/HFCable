package com.hbhongfei.hfcable.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Companyimage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companyimage", catalog = "hfcable")
public class Companyimage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String image;

	// Constructors

	/** default constructor */
	public Companyimage() {
	}

	/** full constructor */
	public Companyimage(String image) {
		this.image = image;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Image", nullable = false, length = 2000)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}