package com.uni.UniversityWebService.model;

public class TransactionType {
	
	private Long id;
	private String name;
	
	public TransactionType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TransactionType() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
