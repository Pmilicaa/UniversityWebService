package com.uni.UniversityWebService.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;

public class TeachingDto {

  
    private Long id;
    private String title;
    private int ects;
    private Teacher teacher;
    private TeacherDto teacherDto;
    private TeachingType teachingType;
    private CourseSpecification courseSpecification;
    private CourseSpecificationDto courseSpecificationDto;
    
    
    
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
    	this.teacherDto = new TeacherDto(teaching.getTeacher());
    	this.courseSpecificationDto = new CourseSpecificationDto(teaching.getCourseSpecification());
    	this.teachingType = teaching.getTeachingType();
	}
    

	public TeacherDto getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(TeacherDto teacherDto) {
		this.teacherDto = teacherDto;
	}

	public CourseSpecificationDto getCourseSpecificationDto() {
		return courseSpecificationDto;
	}

	public void setCourseSpecificationDto(CourseSpecificationDto courseSpecificationDto) {
		this.courseSpecificationDto = courseSpecificationDto;
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

	public TeachingDto() {
		super();
	}
	
  public CourseSpecification getCourseSpecification() {
		return courseSpecification;
	}

	public void setCourseSpecification(CourseSpecification courseSpecification) {
		this.courseSpecification = courseSpecification;
	}

}
