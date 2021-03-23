package com.uni.UniversityWebService.services;

import java.util.List;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ExamPartRepository examPartRepository;

	public Student findByOne(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void remove(Student student) {
		studentRepository.delete(student);
	}

	public List<Student> findAllStudents(){
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student){
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
	
//	public List<CourseSpecification> GetPassedExamsByStudent(Long id) {
//		Student student = studentRepository.findById(id).orElse(null);
//		
//	}
		
	

	// TODO: Return all exams based on student
	public List<ExamPart> findAllExamParts(Student student){
		return examPartRepository.findAll();
	}

	public void increaseStudentBalance(Student student, int amount){
		student.setBalance(student.getBalance() + amount);

		studentRepository.save(student);
	}

	public void decreaseStudentBalance(Student student, int amount){
		student.setBalance(student.getBalance() + amount);

		studentRepository.save(student);
	}
}
