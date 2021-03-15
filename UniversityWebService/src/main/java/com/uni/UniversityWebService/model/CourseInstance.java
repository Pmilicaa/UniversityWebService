package com.uni.UniversityWebService.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courseInstance")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "code")
    private String code;
    private CourseSpecification courseSpecification;

    @OneToMany(
            mappedBy = "courseInstance",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Teaching> teachings;

    @OneToMany(
            mappedBy = "courseInstance",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Enrollment> enrollments;

    public CourseInstance(Long id, Date startDate, Date endDate, String code, CourseSpecification courseSpecification, List<Teaching> teachings, List<Enrollment> enrollments) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        this.courseSpecification = courseSpecification;
        this.teachings = teachings;
        this.enrollments = enrollments;
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

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
