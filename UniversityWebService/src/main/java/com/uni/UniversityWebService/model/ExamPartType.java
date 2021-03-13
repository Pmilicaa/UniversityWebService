package com.uni.UniversityWebService.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExamPartType")
public class ExamPartType {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "examPartTypeId", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "code", unique = false, nullable = false)
	private String code;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "examPartType")
	private Set<ExamPart> examParts = new HashSet<ExamPart>();

	
	public ExamPartType(Long id, String name, String code, Set<ExamPart> examParts) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.examParts = examParts;
	}
	
	public ExamPartType() {
		
	}

	public Long getId() {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<ExamPart> getExamParts() {
		return examParts;
	}

	public void setExamParts(Set<ExamPart> examParts) {
		this.examParts = examParts;
	}
	
}
