package com.uni.UniversityWebService.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;

public class TeachingDto {

  
    private Long id;
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
   
	public TeachingDto(Teaching teaching) {
		super();
		this.id = teaching.getId();
		this.title = teaching.getCourseSpecification().getTitle();
		this.ects = teaching.getCourseSpecification().getECTS();
		this.teacher = teaching.getTeacher();
		this.teachingType = teaching.getTeachingType();
		this.code = teaching.getCode();
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
