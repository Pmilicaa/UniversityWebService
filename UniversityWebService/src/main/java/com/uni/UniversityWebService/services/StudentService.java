package com.uni.UniversityWebService.services;

import java.util.*;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.User;


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
	
	@Autowired
	private EnrollmentService enrollment;
	
	@Autowired UserService userService;

	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void remove(Student student) {
		student.setActive(false);
		studentRepository.save(student);
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
		for (CourseSpecification courseSpec : courseSpecificationRepository.findAll()) {

			ExamPart colloqPart = new ExamPart(new Date("20/1/2021"), "100", 0, 10, examPartTypeColloq, notRegisteredStatus);
			ExamPart homeworkPart = new ExamPart(new Date("20/1/2021"), "100", 0, 20, examPartTypeHomework, notRegisteredStatus);
			ExamPart finalPart = new ExamPart(new Date("20/1/2021"), "100", 0, 30, examPartTypeFinal, notRegisteredStatus);
			Exam exam = new Exam(0, 0, null, null, januaryPeriod);
			exam.getExamParts().add(colloqPart);
			exam.getExamParts().add(homeworkPart);
			exam.getExamParts().add(finalPart);

			Enrollment enrollment = new Enrollment(exam, courseSpec, student);
			exam.setEnrollment(enrollment);

			examPartService.save(colloqPart);
			examPartService.save(homeworkPart);
			examPartService.save(finalPart);
			examService.save(exam);
			enrollmentService.save(enrollment);
		}

		return student;
	}
}
