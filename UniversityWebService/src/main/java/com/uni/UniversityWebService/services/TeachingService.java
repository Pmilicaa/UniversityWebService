package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import com.uni.UniversityWebService.repositories.TeachingTypeRepository;

@Service
public class TeachingService {

	@Autowired
	TeachingRepository teachingRepository;
	
	@Autowired
	TeachingTypeRepository teachingTypeRepository;
	
	@Autowired
	CourseSpecificationRepository courseSpecificationRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	public List<Teaching> findAllByTeacher(Long id) {
		
		return teachingRepository.findByTeacher_id(id);
	}
	
	public List<Teaching> findAllByCourse(Long id) {
		return teachingRepository.findByCourseSpecification_id(id);
	}
	
	public List<Teaching> findAllTeaching() {
		return teachingRepository.findAll();
	}
	
	public Teaching findOne(Long id) {
		return teachingRepository.findById(id).get();
	}
	public Teaching save(Teaching teaching) {
		return teachingRepository.save(teaching);
	}
	public Teaching addTeaching (Long id) {
		
		CourseSpecification oopCourse = courseSpecificationRepository.findByTitle("Object oriented programming");
		TeachingType teachingType = teachingTypeRepository.findByCode("P");
		Teacher teacher = teacherRepository.findById(id).get();
		
		Teaching teaching = new Teaching(oopCourse,teachingType,teacher);
		
		teachingRepository.save(teaching);
		List<Teaching> teachings = new ArrayList();
		teachings.add(teaching);
		teacher.setTeachings(teachings);
		teacherRepository.save(teacher);
		return teaching;
		
	}
	
//	public Teaching addTeaching() {
//		return null;}
}
