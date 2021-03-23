package com.uni.UniversityWebService.model;

import javax.persistence.*;

@Entity
@Table(name = "teaching")
public class Teaching {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseInstance", referencedColumnName = "courseInstanceId")
    private CourseInstance courseInstance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TecherId", referencedColumnName = "id")
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teachingType_id", referencedColumnName = "id")
    private TeachingType teachingType;

    @Column(name = "code")
    private String code;

    public Teaching(Long id, CourseInstance courseInstance, TeachingType teachingType, String code, Teacher teacher) {
        this.id = id;
        this.courseInstance = courseInstance;
        this.teachingType = teachingType;
        this.code = code;
        this.teacher= teacher;
    }
    public Teaching(CourseInstance courseInstance, TeachingType teachingType, String code, Teacher teacher) {
        this.courseInstance = courseInstance;
        this.teachingType = teachingType;
        this.code = code;
        this.teacher= teacher;
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

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
}
