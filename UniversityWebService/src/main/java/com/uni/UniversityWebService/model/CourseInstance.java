package com.uni.UniversityWebService.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courseInstance")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseInstanceId")
    private Long id;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
	@JoinColumn(name = "courseSpecificationsId", referencedColumnName = "id", nullable = false)
    private CourseSpecification courseSpecification;


    public CourseInstance(Long id, Date startDate, Date endDate, CourseSpecification courseSpecification) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseSpecification = courseSpecification;
    }
    public CourseInstance(Date startDate, Date endDate, CourseSpecification courseSpecification) {
      
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseSpecification = courseSpecification;
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


    public CourseSpecification getCourseSpecification() {
        return courseSpecification;
    }

    public void setCourseSpecification(CourseSpecification courseSpecification) {
        this.courseSpecification = courseSpecification;
    }

}
