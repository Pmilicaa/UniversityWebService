package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPart;
import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.repositories.EnrollmentRepository;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ExamPartRepository examPartRepository;
	
	
	public List<CourseInstance> findTeacherCourses(Long id){
		
		Teacher teacher = teacherRepository.findById(id).get();
		List<CourseInstance> courseInstances = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			courseInstances.add(t.getCourseInstance());
		}
		return courseInstances;
	}
	public Teaching addTeacherTeachings(Teaching teaching, Long id) {
		
		Teacher teacher = teacherRepository.findById(id).get();
		teacher.getTeachings().add(teaching);
		teacherRepository.save(teacher);
		return teaching;
		
	}
	public Teacher findById(Long id) {
		return teacherRepository.findById(id).get();
	}

	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	/*
	 * public List <ExamPart> findTeacherExams(Long id)
	 * { Teacher teacher =teacherRepository.findById(id).get();
	 *  List<ExamPart> examParts = new ArrayList<>(); 
	 *  for(Teaching t : teacher.getTeachings())
	 *   { for(Enrollment e : t.getCourseInstance().getEnrollments())
	 *    { for(ExamPeriod ep : e.getExamPeriods()) 
	 *    { for(Exam exam : ep.getExams()) 
	 *    { for(ExamPart examPa :exam.getExamParts()) 
	 *    { examParts.add(examPa); } } } } } 
	 *    return examParts;
	 * 
	 * }
	 */
	public List<ExamPart> findExamParts(){
		List<ExamPart> examParts =examPartRepository.findAll();
		return examParts;
	}
	public List<Student> findTeacherStudents(Long id){
		Teacher teacher = teacherRepository.findById(id).get();
		List<Student> students = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			for(Enrollment en: t.getCourseInstance().getEnrollments()) {
				students.add(en.getStudent());
			}
		}
		return students;
	}
	public List<Student> findStudentsInfo(Long id){
		Teacher teacher = teacherRepository.findById(id).get();
		List<Enrollment> enrollments = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			for(Enrollment en: t.getCourseInstance().getEnrollments()) {
				enrollments.add(en);
			}
		}
		List<Student> students = new ArrayList<>();
		for(Enrollment en : enrollments) {
			students.add(en.getStudent());
		}
		return students;
	}
	
}
