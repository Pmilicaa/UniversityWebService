package com.uni.UniversityWebService.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "teaching")
public class Teaching {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseSpecificationId", referencedColumnName = "id")
    private CourseSpecification courseSpecification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TecherId", referencedColumnName = "id")
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teachingType_id", referencedColumnName = "id")
    private TeachingType teachingType;

    @Column(name = "code")
    private String code;
    
    @OneToOne
    @JoinColumn(name="exam_id", nullable = false)
	private Exam exam;

    
    public Teaching(Long id, CourseSpecification courseSpecification, Teacher teacher, TeachingType teachingType,
			String code, Exam exam) {
		super();
		this.id = id;
		this.courseSpecification = courseSpecification;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.code = code;
		this.exam = exam;
	}

	public Teaching(CourseSpecification courseSpecification, TeachingType teachingType, String code, Teacher teacher, Exam exam) {
        this.courseSpecification = courseSpecification;
        this.teachingType = teachingType;
        this.code = code;
        this.teacher= teacher;
        this.exam = exam;
    }

    public Teaching() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseSpecification getCourseSpecification() {
		return courseSpecification;
	}
	public void setCourseSpecification(CourseSpecification courseSpecification) {
		this.courseSpecification = courseSpecification;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
