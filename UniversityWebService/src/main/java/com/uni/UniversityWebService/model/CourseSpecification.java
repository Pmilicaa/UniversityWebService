package com.uni.UniversityWebService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courseSpecification")
public class CourseSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "ects")
    private int ECTS;

    @Column(name = "code")
    private String code;

    @OneToMany(
            mappedBy = "courseSpecification",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL

    )
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
