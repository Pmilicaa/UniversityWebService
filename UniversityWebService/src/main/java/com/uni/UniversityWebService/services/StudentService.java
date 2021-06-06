package com.uni.UniversityWebService.services;

import java.util.*;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ExamPartService examPartService;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private ExamService examService;

	@Autowired
	ExamPeriodRepository examPeriodRepository;

	@Autowired
	private CourseSpecificationRepository courseSpecificationRepository;

	@Autowired
	TeachingRepository teachingRepository;

	@Autowired
	private ExamPartTypeRepository examPartTypeRepository;

	@Autowired
	private ExamPartStatusRepository examPartStatusRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void remove(Student student) {
		studentRepository.delete(student);
	}

	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student){
		String studentPassword = student.getUser().getPassword();
		student.getUser().setPassword(bCryptPasswordEncoder.encode(studentPassword));
		studentRepository.save(student);
		return student;
	}

	public Student updateStudent(Student student){
		Student studentToUpdate = studentRepository.findById(student.getId()).get();
		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());

		studentRepository.save(studentToUpdate);

		return studentToUpdate;
	}


	public List<CourseSpecification> getRemainingExamsByStudent(Long studentId) {
		List<CourseSpecification> cs = new ArrayList<CourseSpecification>();
		Student student = studentRepository.findById(studentId).get();
		for (Enrollment enroll : student.getEnrollments()) {
			if(enroll.getExam().getGrade() == 5) {
				cs.add(enroll.getCourseSpecification());
			}
		}
		return cs;
	}


	// TODO: Return all exams based on student
	public List<ExamPart> findAllExamParts(Student student){
		return examPartService.findAll();
	}

	public void increaseStudentBalance(Student student, int amount){
		student.setBalance(student.getBalance() + amount);

		studentRepository.save(student);
	}

	public void decreaseStudentBalance(Student student, int amount){
		student.setBalance(student.getBalance() - amount);

		studentRepository.save(student);
	}

	public Student findByUserUsername(String username){
		return studentRepository.findByUser_UserName(username);
	}

	public Student initEnrollments(Student student){
		ExamPartType examPartTypeColloq = examPartTypeRepository.findByCode("C");
		ExamPartType examPartTypeHomework = examPartTypeRepository.findByCode("H");
		ExamPartType examPartTypeFinal = examPartTypeRepository.findByCode("F");

		ExamPartStatus notRegisteredStatus = examPartStatusRepository.findByCode("N");

		ExamPeriod januaryPeriod = examPeriodRepository.findByName("January");

		CourseSpecification mathCourse = courseSpecificationRepository.findByTitle("Mathematics");
		CourseSpecification oopCourse = courseSpecificationRepository.findByTitle("Object oriented programming");

		// Matematika
		ExamPart colloqPart = new ExamPart(new Date("20/1/2021"), "100", 0, 10, examPartTypeColloq, notRegisteredStatus);
		ExamPart homeworkPart = new ExamPart(new Date("20/1/2021"), "100", 0, 20, examPartTypeHomework, notRegisteredStatus);
		ExamPart finalPart = new ExamPart(new Date("20/1/2021"), "100", 0, 30, examPartTypeFinal, notRegisteredStatus);
		Exam mathExam = new Exam(0, 0, null, null, januaryPeriod);
		mathExam.getExamParts().add(colloqPart);
		mathExam.getExamParts().add(homeworkPart);
		mathExam.getExamParts().add(finalPart);

		Enrollment mathEnrollment = new Enrollment(mathExam, mathCourse, student);
		mathExam.setEnrollment(mathEnrollment);

		examPartService.save(colloqPart);
		examPartService.save(homeworkPart);
		examPartService.save(finalPart);
		examService.save(mathExam);
		enrollmentService.save(mathEnrollment);

		// OOP
		ExamPart colloqPartOOP = new ExamPart(new Date("20/5/2021"), "100", 0, 10, examPartTypeColloq, notRegisteredStatus);
		ExamPart homeworkPartOOP = new ExamPart(new Date("25/6/2021"), "200", 0, 20, examPartTypeHomework, notRegisteredStatus);
		ExamPart finalPartOOP = new ExamPart(new Date("15/7/2021"), "300", 0, 30, examPartTypeFinal, notRegisteredStatus);
		Exam oopExam= new Exam(0, 0, null, null, januaryPeriod);
		oopExam.getExamParts().add(colloqPartOOP);
		oopExam.getExamParts().add(homeworkPartOOP);
		oopExam.getExamParts().add(finalPartOOP);

		Enrollment oopEnrollment = new Enrollment(oopExam, oopCourse, student);
		oopExam.setEnrollment(oopEnrollment);

		examPartService.save(colloqPartOOP);
		examPartService.save(homeworkPartOOP);
		examPartService.save(finalPartOOP);
		examService.save(oopExam);
		enrollmentService.save(oopEnrollment);

		return student;
	}
}
