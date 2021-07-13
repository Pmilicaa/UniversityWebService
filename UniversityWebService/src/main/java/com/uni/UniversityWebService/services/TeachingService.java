package com.uni.UniversityWebService.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public Teaching addTeaching (Long id, String title, String code) {
		
		CourseSpecification oopCourse = courseSpecificationRepository.findByTitle(title);
		TeachingType teachingType = teachingTypeRepository.findByCode(code);
		Teacher teacher = teacherRepository.findById(id).get();
		
		 String pattern = "yyyy-MM-dd";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 System.out.println(date);

		 Date date1;
		try {
			date1 = simpleDateFormat.parse(date);
			 System.out.println(date1);
				CourseInstance courseInstance = new CourseInstance(date1,null,oopCourse);
				CourseInstance newCourseInstance = courseInstanceRepository.save(courseInstance);
				oopCourse.getCourseInstances().add(newCourseInstance);		
				courseSpecificationRepository.save(oopCourse);

				Teaching teaching = new Teaching(oopCourse,teachingType,"M",teacher);
				List<Teaching> teachings = new ArrayList();
				Teaching newTeaching = teachingRepository.save(teaching);
				teacher.getTeachings().add(newTeaching);
				teacherRepository.save(teacher);
				return teaching;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		/*
		 * teachings.add(teaching); teacher.setTeachings(teachings);
		 */
		
		
	
		
	}
}
