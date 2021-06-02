package com.uni.UniversityWebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="uri")
	private String uri;
	
	@OneToOne
	@JoinColumn(name="documentTypeId", referencedColumnName = "id")
	private DocumentType documentType;
	
	public Document(Long id, String title, String uri, DocumentType documentType) {
		super();
		this.id = id;
		this.title = title;
		this.uri = uri;
		this.documentType = documentType;
	}

	public Document(String title, String uri, DocumentType documentType) {
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
