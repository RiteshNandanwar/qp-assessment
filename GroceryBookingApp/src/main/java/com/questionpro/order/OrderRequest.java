package com.questionpro.order;

public class OrderRequest {

	private Long[] items;
	private String notes;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public OrderRequest(Long[] items, String notes) {
		super();
		this.items = items;
		this.notes = notes;
	}

	public Long[] getItems() {
		return items;
	}

	public void setItems(Long[] items) {
		this.items = items;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
