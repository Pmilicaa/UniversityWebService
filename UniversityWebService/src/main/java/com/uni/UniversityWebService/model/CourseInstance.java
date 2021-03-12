package com.uni.UniversityWebService.model;

import java.util.Date;
import java.util.List;

public class CourseInstance {

    private Long id;
    private Date startDate;
    private Date endDate;
    private String code;
    private CourseSpecification courseSpecification;
    private List<Teaching> teachings;

    public CourseInstance(Long id, Date startDate, Date endDate, String code, CourseSpecification courseSpecification, List<Teaching> teachings) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        this.courseSpecification = courseSpecification;
        this.teachings = teachings;
    }

    public CourseInstance() {
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CourseSpecification getCourseSpecification() {
        return courseSpecification;
    }

    public void setCourseSpecification(CourseSpecification courseSpecification) {
        this.courseSpecification = courseSpecification;
    }

    public List<Teaching> getTeachings() {
        return teachings;
    }

    public void setTeachings(List<Teaching> teachings) {
        this.teachings = teachings;
    }
}
