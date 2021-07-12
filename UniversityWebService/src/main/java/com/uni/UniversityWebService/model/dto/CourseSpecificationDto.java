package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class CourseSpecificationDto {

    private long id;
    private String title;
    private int ECTS;
    private String code;
    private List<CourseInstanceDto> courseInstanceDtos;
    //private List<EnrollmentDto> enrollmentDtos;

    public CourseSpecificationDto(CourseSpecification courseSpecification){
        this.id = courseSpecification.getId();
        this.title = courseSpecification.getTitle();
        this.ECTS = courseSpecification.getECTS();
        this.code = courseSpecification.getCode();
        this.courseInstanceDtos = convertCourseInstancesToDtos(courseSpecification.getCourseInstances());
        //this.enrollmentDtos = convertEnrollmentToDtos(courseSpecification.getEnrollments());
    }

    public List<CourseInstanceDto> convertCourseInstancesToDtos(List<CourseInstance> courseInstances){
        List<CourseInstanceDto> courseInstanceDtos = new ArrayList<>();
        for (CourseInstance courseInstance : courseInstances) {
            courseInstanceDtos.add(new CourseInstanceDto(courseInstance));
        }

        return courseInstanceDtos;
    }

    public List<EnrollmentDto> convertEnrollmentToDtos(List<Enrollment> enrollments){
        List<EnrollmentDto> enrollmentDtos = new ArrayList<>();
        for(Enrollment enrollment : enrollments){
            enrollmentDtos.add(new EnrollmentDto(enrollment));
        }

        return enrollmentDtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CourseSpecificationDto() {
		super();
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

    public List<CourseInstanceDto> getCourseInstanceDtos() {
        return courseInstanceDtos;
    }

    public void setCourseInstanceDtos(List<CourseInstanceDto> courseInstanceDtos) {
        this.courseInstanceDtos = courseInstanceDtos;
    }

//    public List<EnrollmentDto> getEnrollmentDtos() {
//        return enrollmentDtos;
//    }
//
//    public void setEnrollmentDtos(List<EnrollmentDto> enrollmentDtos) {
//        this.enrollmentDtos = enrollmentDtos;
//    }
}
