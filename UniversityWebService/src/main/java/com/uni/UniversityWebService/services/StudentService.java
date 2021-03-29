package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;

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


	/*public List<CourseSpecification> GetRemainingExamsByStudent(Long studentId) {
		List<CourseSpecification> cs = new ArrayList<CourseSpecification>();
		Student student = studentRepository.findById(studentId).get();
		for (Enrollment enroll : student.getEnrollments()) {
			for(Exam ex : enroll.getExams()) {
			if(ex.getGrade() == 5) {
					cs.add(enroll.getCourseSpecification());
				}
			}
		}
		return cs;
	}*/

	
	//TODO: Check is this works (Find all remaining exams for student)
//	public List<CourseSpecification> GetRemainingExamsByStudent(Long studentId) {
//		List<CourseSpecification> cs = new ArrayList<CourseSpecification>();
//		Student student = studentRepository.findById(studentId).orElse(null);
//		List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student.getId());
//		for (Enrollment enroll : enrollment) {
//			List<ExamPeriod> examPeriods = examPeriodRepository.findByEnrollment_id(enroll.getId());
//				for (ExamPeriod ep : examPeriods) {
//					List<Exam> exams = examRepository.findByExamPeriod_id(ep.getId());
//					for (Exam exam : exams) {
//						if (exam.getGrade() == 5) {
//							cs.add(enroll.getCourseSpecification());
//						}
//					}
//				}
//		}
//		return cs;
//	}
	
	
	
//	public ExamPartStatus examInformation(Long studentId) {
//		ExamPartStatus examP = null;
//		Student student = studentRepository.findById(studentId).orElse(null);
//		List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student.getId());
//		for (Enrollment enroll : enrollment) {
//			List<ExamPeriod> examPeriods = examPeriodRepository.findByEnrollment_id(enroll.getId());
//				for (ExamPeriod ep : examPeriods) {
//					List<Exam> exams = examRepository.findByExamPeriod_id(ep.getId());
//					for (Exam ex : exams) {
//						for (ExamPart examPart : ex.getExamParts()) {
//							examP = examPart.getExamPartStatus();
//						}
//					}
//				}
//		}
//		return examP;
//	}
	
	
	//TODO: FINISH THIS (Student want to see wich teacher teaching the course)
//	public List<Teacher> WichTeacherIsTeachingTheCourse(Long studentId, Long courseInstanceId) {
//		List<Teacher> teachers = new ArrayList<Teacher>();
//		Student student = studentRepository.findById(studentId).orElse(null);
//		List<Enrollment> enrollment = enrollmentRepository.findByStudent_id(student.getId());
//		for(Enrollment enr : enrollment) {
//			
//		}
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
		student.setBalance(student.getBalance() - amount);

		studentRepository.save(student);
	}
}
