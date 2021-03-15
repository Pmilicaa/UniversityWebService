package com.uni.UniversityWebService.model;


public class Document {
	
	private Long id;
	private String title;
	private String uri;
	private DocumentType documentType;
	
	public Document(Long id, String title, String uri, DocumentType documentType) {
		super();
		this.id = id;
		this.title = title;
		this.uri = uri;
		this.documentType = documentType;
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
	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	
	

}
