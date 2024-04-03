package com.questionpro.order;

public class OrderRequest {

	private Long[] items;
	private String notes;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
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
