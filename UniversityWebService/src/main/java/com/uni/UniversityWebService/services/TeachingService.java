package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.TeachingType;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
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
	
	@Autowired
	CourseInstanceRepository courseInstanceRepository;
	
	public List<Teaching> findAllByTeacher(Long id) {
		return teachingRepository.findByTeacher_id(id);
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
		
		CourseInstance courseInstance = new CourseInstance(new Date("2010/10/10"),new Date("2029/03/03"),oopCourse);
		CourseInstance newCourseInstance = courseInstanceRepository.save(courseInstance);
		oopCourse.getCourseInstances().add(newCourseInstance);		
		courseSpecificationRepository.save(oopCourse);

		Teaching teaching = new Teaching(oopCourse,teachingType,"M",teacher);
		List<Teaching> teachings = new ArrayList();
		Teaching newTeaching = teachingRepository.save(teaching);
		teacher.getTeachings().add(newTeaching);
		/*
		 * teachings.add(teaching); teacher.setTeachings(teachings);
		 */
		
		
		teacherRepository.save(teacher);
		return teaching;
		
	}
}
