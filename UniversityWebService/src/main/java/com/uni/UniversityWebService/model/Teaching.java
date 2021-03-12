package com.uni.UniversityWebService.model;

public class Teaching {

    private Long id;
    private CourseInstance courseInstance;
    private TeachingType teachingType;
    private String code;

    public Teaching(Long id, CourseInstance courseInstance, TeachingType teachingType, String code) {
        this.id = id;
        this.courseInstance = courseInstance;
        this.teachingType = teachingType;
        this.code = code;
    }

    public Teaching() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseInstance getCourseInstance() {
        return courseInstance;
    }

    public void setCourseInstance(CourseInstance courseInstance) {
        this.courseInstance = courseInstance;
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
}
