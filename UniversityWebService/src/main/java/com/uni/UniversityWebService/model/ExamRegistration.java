package com.uni.UniversityWebService.model;

import java.util.Date;

public class ExamRegistration {

	private long id;
	private Student student;
	private CourseInstance course;
	private Date dateOfRegistration;
	private double price;
	private ExamPart examPart;
	private String classroom;


	public ExamRegistration(long id, Student student, CourseInstance course, Date dateOfRegistration, double price,
				ExamPart examPart, String classroom) {
			super();
		this.id = id;
		this.student = student;
		this.course = course;
		this.dateOfRegistration = dateOfRegistration;
		this.price = price;
		this.examPart = examPart;
		this.classroom = classroom;
	}
	public ExamRegistration(Student student, CourseInstance course, Date dateOfRegistration, double price,
			ExamPart examPart, String classroom) {
		super();
		this.student = student;
		this.course = course;
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
		public CourseInstance getCourse() {
			return course;
		}
		public void setCourse(CourseInstance course) {
			this.course = course;
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
