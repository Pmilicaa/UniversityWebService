package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Enrollment;

public class EnrollmentDto {

	private Long id;
	private StudentDto studentDto;
	private CourseSpecificationDto courseSpecificationDto;
	private ExamDto examDto;
	
    public EnrollmentDto(){
    	
    }
    
    public EnrollmentDto(Enrollment enrollment) {
    	this.id = enrollment.getId();
    	this.studentDto = new StudentDto(enrollment.getStudent());
    	this.courseSpecificationDto = new CourseSpecificationDto(enrollment.getCourseSpecification());
    	this.examDto = new ExamDto(enrollment.getExam());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public CourseSpecificationDto getCourseSpecificationDto() {
		return courseSpecificationDto;
	}

	public void setCourseSpecificationDto(CourseSpecificationDto courseSpecificationDto) {
		this.courseSpecificationDto = courseSpecificationDto;
	}

	public ExamDto getExamDto() {
		return examDto;
	}

	public void setExamDto(ExamDto examDto) {
		this.examDto = examDto;
	}
    
    
}
