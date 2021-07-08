package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.model.dto.ExamPartProfessorDto;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.repositories.EnrollmentRepository;
import com.uni.UniversityWebService.repositories.ExamPartRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private TeachingRepository teachingRepository;
	
	@Autowired
	private ExamPartRepository examPartRepository;
	
	
	public List<CourseInstance> findTeacherCourses(Long id){
		
		Teacher teacher = teacherRepository.findById(id).get();
		List<CourseInstance> courseInstances = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			for(CourseInstance ci : t.getCourseSpecification().getCourseInstances())
			courseInstances.add(ci);
		}
		return courseInstances;
	}

	public List<ExamPartProfessorDto> findExamPartsAndCourseSepcificationForTeacher(Long id){
		List<ExamPartProfessorDto> examPartProfessorDtos= new ArrayList<>();
		List<ExamPart>examParts = new ArrayList<>();
		List<CourseSpecification> courseSpecification = new ArrayList<>();
		List<Teaching> teachingAll=teachingRepository.findAll();
		for(Teaching t : teachingAll) {
			if (t.getTeacher().getId() == id){

				for (ExamPart ep : t.getExam().getExamParts()) {
					ExamPartProfessorDto examPartProfessorDto= new ExamPartProfessorDto();
					examPartProfessorDto.setCourse(t.getCourseSpecification().getTitle());

					examPartProfessorDto.setClassroom(ep.getClassroom());
					examPartProfessorDto.setExamPartStartDate(ep.getExamPartStartDate());
					examPartProfessorDtos.add(examPartProfessorDto);
				}
		}}
		return examPartProfessorDtos;
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

	public List<Teacher> findAllTeachers(){
		return teacherRepository.findAll();
	}
	public List<ExamPart> findExamParts(){
		List<ExamPart> examParts =examPartRepository.findAll();
		return examParts;
	}
	public List<Student> findTeacherStudents(Long id){
		Teacher teacher = teacherRepository.findById(id).get();
		List<Student> students = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			for(Enrollment en: t.getCourseSpecification().getEnrollments()) {
				students.add(en.getStudent());
			}
		}
		return students;
	}
	public List<Student> findStudentsInfo(Long id){
		Teacher teacher = teacherRepository.findById(id).get();
		List<Enrollment> enrollments = new ArrayList<>();
		for(Teaching t : teacher.getTeachings()) {
			for(Enrollment en: t.getCourseSpecification().getEnrollments()) {
				enrollments.add(en);
			}
		}
		List<Student> students = new ArrayList<>();
		for(Enrollment en : enrollments) {
			students.add(en.getStudent());
		}
		return students;
	}
	
	public List<ExamPart> findTeacherExamParts(Long id){

		List<Teaching> teachingAll=teachingRepository.findAll();
		List<ExamPart>examParts = new ArrayList<>();
		for(Teaching teaching : teachingAll) {
			if (teaching.getTeacher().getId() == id) {
				for (ExamPart ep : teaching.getExam().getExamParts()) {

					examParts.add(ep);
				}
			}
		}
		return examParts;
		}
	}

