package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamRegistration;

import java.util.Date;

public class ExamRegistrationDto {

    private long id;
    private StudentDto studentDto;
    private CourseSpecificationDto courseSpecificationDto;
    private Date dateOfRegistration;
    private double price;
    private ExamPart examPart;

    public ExamRegistrationDto(ExamRegistration examRegistration) {
        this.id = examRegistration.getId();
        this.studentDto = new StudentDto(examRegistration.getStudent());
        this.courseSpecificationDto = new CourseSpecificationDto(examRegistration.getCourse());
        this.dateOfRegistration = examRegistration.getDateOfRegistration();
        this.price = examRegistration.getPrice();
        this.examPart = examRegistration.getExamPart();
    }

    public ExamRegistrationDto(long id, StudentDto studentDto, CourseSpecificationDto courseSpecificationDto, Date dateOfRegistration, double price, ExamPart examPart, String classroom) {
        this.id = id;
        this.studentDto = studentDto;
        this.courseSpecificationDto = courseSpecificationDto;
        this.dateOfRegistration = dateOfRegistration;
        this.price = price;
        this.examPart = examPart;
    }

    public ExamRegistrationDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ExamPart getExamPart() {
        return examPart;
    }

    public void setExamPart(ExamPart examPart) {
        this.examPart = examPart;
    }
}
