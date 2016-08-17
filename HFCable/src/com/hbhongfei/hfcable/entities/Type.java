package com.hbhongfei.hfcable.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */
@Entity

@Table(name = "type", catalog = "hfcable")
public class Type implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String typeName;
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public Type(String typeName, Set<Product> products) {
		this.typeName = typeName;
		this.products = products;
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

	@Column(name = "typeName", nullable = false, length = 50)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + ", getId()="
				+ getId() + ", getTypeName()=" + getTypeName()
				+ ", getClass()=" + getClass()  + "]";
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "type")
	public Set<Product> getProducts() {
		return this.products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}