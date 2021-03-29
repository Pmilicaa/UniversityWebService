package com.uni.UniversityWebService.model.dto;

import java.util.Date;

import javax.persistence.*;

import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;

public class TeachingDto {

  
    private Long id;
    private Date startDate;
    private Date endDate;
    private String title;
    private int ects;
    private Teacher teacher;
    private TeachingType teachingType;
    private String code;
    
    
    
//	public TeachingDto(Teaching teaching) {
//		super();
//		this.id = teaching.getId();
//		this.startDate = teaching.getCourseInstance().getStartDate();
//		this.endDate = teaching.getCourseInstance().getEndDate();
//		this.title = teaching.getCourseInstance().getCourseSpecification().getTitle();
//		this.ects = teaching.getCourseInstance().getCourseSpecification().getECTS();
//		this.teacher = teaching.getTeacher();
//		this.teachingType = teaching.getTeachingType();
//		this.code = teaching.getCode();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeachingType getTeachingType() {
		return teachingType;
	}

	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TeachingDto() {
		super();
	}
	

}
