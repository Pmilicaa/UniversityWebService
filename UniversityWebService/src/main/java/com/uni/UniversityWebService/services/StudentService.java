package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.model.ExamPeriod;
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
	private ExamPartRepository examPartRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	ExamRepository examRepository;

	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	@Autowired
	TeachingRepository teachingRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired UserService userService;

	public Student findByOne(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void remove(Student student) {
//		User user = userService.findById(student.getUser().getId());
//		userService.deleteUser(user);
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
		return examPartRepository.findAll();
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
}
