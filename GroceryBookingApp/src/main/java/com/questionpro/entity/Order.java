package com.questionpro.entity;

import java.util.Date;
import java.util.List;

import org.springframework.lang.Nullable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name = "TBORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Date orderDate;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER) // Do not remove product if order is removed.
	@JoinColumn(name = "order_id")
	private List<Product> products;
	private Double totalAmount;
	private String status;
	@Nullable
	private String notes;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(@Size(max = 6) Integer orderId, Date orderDate, List<Product> products, Double totalAmount, String status,
			String notes) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.products = products;
		this.totalAmount = totalAmount;
		this.status = status;
		this.notes = notes;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
