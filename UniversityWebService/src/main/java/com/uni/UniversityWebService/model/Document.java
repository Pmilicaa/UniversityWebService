package com.uni.UniversityWebService.model;

public class Document {
	
	private Long id;
	private String title;
	private String uri;
	
	public Document(Long id, String title, String uri) {
		super();
		this.id = id;
		this.title = title;
		this.uri = uri;
	}

	public Document() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	

}
