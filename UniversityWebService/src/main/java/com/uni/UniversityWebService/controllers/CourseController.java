package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.CourseInstance;
import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.dto.CourseInstanceDto;
import com.uni.UniversityWebService.model.dto.CourseSpecificationDto;
import com.uni.UniversityWebService.model.dto.StudentDto;
import com.uni.UniversityWebService.model.dto.TeacherDto;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.TeachingRepository;
import com.uni.UniversityWebService.services.CourseService;
import com.uni.UniversityWebService.services.TeachingService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;
    
	 @Autowired
	 private TeachingRepository teachingRepository;
	 
	 @Autowired
	 private CourseSpecificationRepository courseSpecificationRepository;
	 
	 @Autowired
	 private TeachingService teachingService;

    @GetMapping(path = "/courseInstances")
    public @ResponseBody ResponseEntity<?> getAllInstances(){
        return new ResponseEntity(courseService.findAllCourseInstances(), HttpStatus.OK);
    }

    @GetMapping(path = "/courseSpecifications")
    public @ResponseBody ResponseEntity<?> getAllSpecifications(){
        return new ResponseEntity(courseService.findAllCourseSpecifications(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/courses")
    public @ResponseBody ResponseEntity<List<CourseSpecificationDto>> getAllCourses() {
    	List<CourseSpecification> courses = courseService.findAllCourseSpecifications();
    	List<CourseSpecificationDto> coursesDto = new ArrayList<CourseSpecificationDto>();
    	for (CourseSpecification cs : courses) {
    		coursesDto.add(new CourseSpecificationDto(cs));
    	}
    	return new ResponseEntity<List<CourseSpecificationDto>>(coursesDto, HttpStatus.OK);
    }
    @PostMapping(path= "/courses")
	public @ResponseBody ResponseEntity<CourseSpecification> addCourseSpecification(@RequestBody CourseSpecification courseSpecification){
    	CourseSpecification cs=courseService.saveCourseSpecification(courseSpecification);
		return new ResponseEntity(cs, HttpStatus.OK);
	}




    @GetMapping(path = "/courses/{courseId}")
    public @ResponseBody ResponseEntity<CourseSpecificationDto> getCourse(@PathVariable("courseId") Long courseId) {
    	CourseSpecification cs = courseSpecificationRepository.findById(courseId).get();
    	if(cs == null) {
    		return new ResponseEntity<CourseSpecificationDto>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<CourseSpecificationDto>(new CourseSpecificationDto(cs), HttpStatus.OK);
    }
    
    @GetMapping(path = "/courses/{courseId}/teachers")
	 public @ResponseBody ResponseEntity<List<TeacherDto>> getAllTeacherByCourse(@PathVariable("courseId") Long courseId) {
		 List<Teaching> teachings = teachingService.findAllByCourse(courseId);
		 List<Teacher> teachers = new ArrayList<>();
		 List<TeacherDto> teachersDto = new ArrayList<TeacherDto>();
		 for(Teaching teaching : teachings ) {
			 teachers.add(teaching.getTeacher());
		 }
		 for (Teacher teacher : teachers) {
			 teachersDto.add(new TeacherDto(teacher));
		 }
		 return new ResponseEntity<List<TeacherDto>>(teachersDto, HttpStatus.OK);
	 }
	 
	 @GetMapping(path = "/courses/{courseId}/courseInstances")
	 public @ResponseBody ResponseEntity<List<CourseInstanceDto>> getAllCourseInstancesByCourse(@PathVariable("courseId") Long courseId) {
		 CourseSpecification courseSpecification = courseSpecificationRepository.findById(courseId).get();
		 List<CourseInstance> courseInstances = new ArrayList<CourseInstance>();
		 for(CourseInstance courseInstance : courseSpecification.getCourseInstances()) {
			 courseInstances.add(courseInstance);
		 }
		 List<CourseInstanceDto> courseInstancesDto = new ArrayList<CourseInstanceDto>();
		 for(CourseInstance ci : courseInstances) {
			 courseInstancesDto.add(new CourseInstanceDto(ci));
		 }
		 return new ResponseEntity<List<CourseInstanceDto>>(courseInstancesDto, HttpStatus.OK);
	 }
	 
	 @PutMapping(path = "/courses/{courseId}")
	 public @ResponseBody ResponseEntity<CourseSpecificationDto> updateCourse(@RequestBody CourseSpecificationDto courseSpecificationDto, @PathVariable("courseId") Long courseId) {
		 if(!courseId.equals(courseSpecificationDto.getId())) {
			 return new ResponseEntity<CourseSpecificationDto>(HttpStatus.NOT_FOUND);
		 }
		 CourseSpecification cs = courseSpecificationRepository.findById(courseId).get();
		 if(cs == null) {
	    	return new ResponseEntity<CourseSpecificationDto>(HttpStatus.BAD_REQUEST);
	     }
		 CourseSpecification changedCourseSpecification = courseSpecificationDto.convertCourseSpecificationDtoToCS(cs);
		 cs = courseService.saveCourseSpecification(changedCourseSpecification);
		 
		 return new ResponseEntity<CourseSpecificationDto>(new CourseSpecificationDto(cs), HttpStatus.OK);
	 }
	 
	 @DeleteMapping(path = "/courses/{courseId}")
	 public ResponseEntity<Void> deleteCourse(@PathVariable("courseId") Long courseId) {
		 CourseSpecification cs = courseSpecificationRepository.findById(courseId).get();
		 if(cs == null) {
		    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		 }
		 courseService.deleteCourseSpecification(cs);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	 }

}
