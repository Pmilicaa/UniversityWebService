package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Exam;

public class ExamDto {

	private Long id;
	private int examPoints;
	private int grade;
	private EnrollmentDto enrollmentDto;
	private TeachingDto teachingDto;
	//TODO: INSERT EXAMPERIODDTO!
	
	public ExamDto(Exam exam)  {
		this.id = exam.getId();
		this.examPoints = exam.getExamPoints();
		this.grade = exam.getGrade();
		this.enrollmentDto = new EnrollmentDto(exam.getEnrollment());
		this.teachingDto = new TeachingDto(exam.getTeaching());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getExamPoints() {
		return examPoints;
	}

	public void setExamPoints(int examPoints) {
		this.examPoints = examPoints;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public EnrollmentDto getEnrollmentDto() {
		return enrollmentDto;
	}

	public void setEnrollmentDto(EnrollmentDto enrollmentDto) {
		this.enrollmentDto = enrollmentDto;
	}

	public TeachingDto getTeachingDto() {
		return teachingDto;
	}

	public void setTeachingDto(TeachingDto teachingDto) {
		this.teachingDto = teachingDto;
	}
	
	
}
