package com.questionpro.entity;

import java.io.Serializable;
import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@NotBlank(message = "The Product Name is require")
	private String productName;
	@Nullable
	private String productDescription;
	
	@NotBlank(message = "The Product Price is require")
	private Double productPrice;
	
	@NotBlank(message = "The Product Quantity is require")
	private Integer quantity;
	
	@NotBlank(message = "The Product Category is require")
	private String category;
	
	@NotBlank(message = "The Product Brand is require")
	private String brand;
	
	@NotBlank(message = "The Product Unit is require")
	private String unit;
	@Nullable
	private String nutritionalInformation;
	@Nullable
	private Date expiryDate;
	@Nullable
	private Double weight;
	@Nullable
	private String dimentions;
	
	private Date creationDate;
	@Nullable
	private Date lastUpdatedDate;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, String productName, String productDescription, Double productPrice,
			Integer quantityAvailabe, String catogery, String brand, String unit, String nutritionalInformation,
			Date expiryDate, Double weight, String dimentions, Date creationDate, Date lastUpdatedDate, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.quantity = quantityAvailabe;
		this.category = category;
		this.brand = brand;
		this.unit = unit;
		this.nutritionalInformation = nutritionalInformation;
		this.expiryDate = expiryDate;
		this.weight = weight;
		this.dimentions = dimentions;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getQuantityAvailabe() {
		return quantity;
	}

	public void setQuantityAvailabe(Integer quantityAvailabe) {
		this.quantity = quantityAvailabe;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNutritionalInformation() {
		return nutritionalInformation;
	}

	public void setNutritionalInformation(String nutritionalInformation) {
		this.nutritionalInformation = nutritionalInformation;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDimentions() {
		return dimentions;
	}

	public void setDimentions(String dimentions) {
		this.dimentions = dimentions;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}
