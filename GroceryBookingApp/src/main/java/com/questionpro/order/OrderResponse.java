package com.questionpro.order;

import java.util.Date;
import java.util.List;

import com.questionpro.entity.Product;

public class OrderResponse {

	private Integer orderId;
	private Double totalAmount;
	private String staus;
	private String note;
	private Date orderDate;
	private List<Product> products;

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponse(Integer orderId, Double totalAmount, String staus, String note, Date orderDate,
			List<Product> products) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.staus = staus;
		this.note = note;
		this.orderDate = orderDate;
		this.products = products;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

}
