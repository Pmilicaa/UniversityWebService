package com.uni.UniversityWebService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
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
}
