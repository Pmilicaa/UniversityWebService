package com.uni.UniversityWebService.model;

import java.util.List;

public class CourseSpecification {

    private Long id;
    private String title;
    private int ECTS;
    private String code;
    private List<CourseInstance> courseInstances;

    public CourseSpecification(Long id, String title, int ECTS, String code, List<CourseInstance> courseInstances) {
        this.id = id;
        this.title = title;
        this.ECTS = ECTS;
        this.code = code;
        this.courseInstances = courseInstances;
    }

    public CourseSpecification() {
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

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CourseInstance> getCourseInstances() {
        return courseInstances;
    }

    public void setCourseInstances(List<CourseInstance> courseInstances) {
        this.courseInstances = courseInstances;
    }
}
