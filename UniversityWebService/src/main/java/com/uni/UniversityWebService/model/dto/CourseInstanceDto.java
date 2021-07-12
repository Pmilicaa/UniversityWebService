package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.CourseInstance;

import java.util.Date;

public class CourseInstanceDto {

    private long id;
    private Date startDate;
    private Date endDate;
    //private CourseSpecificationDto courseSpecificationDto;

    public CourseInstanceDto(CourseInstance courseInstance){
        this.id = courseInstance.getId();
        this.startDate = courseInstance.getStartDate();
        this.endDate = courseInstance.getEndDate();
        //this.courseSpecificationDto = new CourseSpecificationDto(courseInstance.getCourseSpecification());
    }

    public CourseInstanceDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

//    public CourseSpecificationDto getCourseSpecificationDto() {
//        return courseSpecificationDto;
//    }
//
//    public void setCourseSpecificationDto(CourseSpecificationDto courseSpecificationDto) {
//        this.courseSpecificationDto = courseSpecificationDto;
//    }
}
