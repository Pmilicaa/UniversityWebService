package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Document;
import com.uni.UniversityWebService.model.DocumentType;

public class DocumentDto {

    private long id;
    private String title;
    private String uri;
    private DocumentType documentType;

    public DocumentDto(Document document){
        this.id = document.getId();
        this.title = document.getTitle();
        this.uri = document.getUri();
        this.documentType = document.getDocumentType();
    }

    public DocumentDto(long id, String title, String uri, DocumentType documentType) {
        this.id = id;
        this.title = title;
        this.uri = uri;
        this.documentType = documentType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
