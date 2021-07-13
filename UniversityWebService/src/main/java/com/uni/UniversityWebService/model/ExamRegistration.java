package com.uni.UniversityWebService.model;

import com.uni.UniversityWebService.model.dto.CourseSpecificationDto;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ExamRegistration")
public class ExamRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="student_id", referencedColumnName = "id")
	private Student student;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="course_id", referencedColumnName = "id")
	private CourseSpecification courseSpecification;
	
	@Column(name="dateOfRegistration")
	private Date dateOfRegistration;
	
	@Column(name="price")
	private double price;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="examPart_id", referencedColumnName = "examPartId")
	private ExamPart examPart;
	
	@Column(name="classroom")
	private String classroom;


	public ExamRegistration(long id, Student student, CourseSpecification courseSpecification, Date dateOfRegistration, double price,
				ExamPart examPart, String classroom) {
			super();
		this.id = id;
		this.student = student;
		this.courseSpecification = courseSpecification;
		this.dateOfRegistration = dateOfRegistration;
		this.price = price;
		this.examPart = examPart;
		this.classroom = classroom;
	}
	public ExamRegistration(Student student, CourseSpecification courseSpecification, Date dateOfRegistration, double price,
			ExamPart examPart, String classroom) {
		super();
		this.student = student;
		this.courseSpecification = courseSpecification;
		this.dateOfRegistration = dateOfRegistration;
		this.price = price;
		this.examPart = examPart;
		this.classroom = classroom;
	}
		public ExamRegistration() {
			super();
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public CourseSpecification getCourse() {
			return courseSpecification;
		}
		public void setCourse(CourseSpecification courseSpecification) {
			this.courseSpecification = courseSpecification;
		}
		public Date getDateOfRegistration() {
			return dateOfRegistration;
		}
		public void setDateOfRegistration(Date dateOfRegistration) {
			this.dateOfRegistration = dateOfRegistration;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public ExamPart getExamPart() {
			return examPart;
		}
		public void setExamPart(ExamPart examPart) {
			this.examPart = examPart;
		}
		public String getClassroom() {
			return classroom;
		}
		public void setClassroom(String classroom) {
			this.classroom = classroom;
		}

}