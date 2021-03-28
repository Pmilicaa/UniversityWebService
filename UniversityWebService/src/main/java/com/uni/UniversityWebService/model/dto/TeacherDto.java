package com.uni.UniversityWebService.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;

public class TeacherDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
    private TeachingType teachingType;
	private Set<Exam> exams = new HashSet<Exam>();
	private Set<ExamPart> examParts = new HashSet<ExamPart>();
	
	
	public TeacherDto(Teacher teacher) {
		super();
		this.id =teacher.getId();
		this.firstName = teacher.getFirstName();
		this.lastName = teacher.getLastName();
		this.username = teacher.getUser().getUserName();
		
	}
	
	public TeacherDto() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TeachingType getTeachingType(Teacher teacher) {
		for(Teaching t : teacher.getTeachings()) {
			teachingType = t.getTeachingType();
		}
		return teachingType;
	}

	public Set<Exam> getExam(Teacher teacher) {
		for(Teaching t : teacher.getTeachings()) {
			for(Exam e : t.getExams()) {
				exams.add(e);
			}
		}
		return exams;
	}

	public Set<ExamPart> getExamParts(Teacher teacher){
		
		for(Teaching t : teacher.getTeachings()) {
			for(Exam e : t.getExams()) {
				for(ExamPart ex : e.getExamParts()) {
					examParts.add(ex);
				}
			}
		}
		return examParts;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
