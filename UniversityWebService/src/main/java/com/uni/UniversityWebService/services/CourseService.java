package com.uni.UniversityWebService.services;


import com.uni.UniversityWebService.model.CourseInstance;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    CourseSpecificationRepository courseSpecificationRepository;


    @Autowired
    CourseInstanceRepository courseInstanceRepository;

    public CourseInstance saveCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public CourseSpecification saveCourseSpecification(CourseSpecification courseSpecification) {
        return courseSpecificationRepository.save(courseSpecification);
    }

    public CourseInstance deleteCourseInstance(CourseInstance courseInstance){
        courseInstanceRepository.delete(courseInstance);

        return courseInstance;
    }

    public void deleteCourseSpecification(CourseSpecification courseSpecification){
    	courseSpecification.setActive(false);
    	courseSpecificationRepository.save(courseSpecification);
    }

    public List<CourseInstance> findAllCourseInstances(){
        return courseInstanceRepository.findAll();
    }

    public List<CourseSpecification> findAllCourseSpecifications(){
        return courseSpecificationRepository.findAll();
    }

    public CourseInstance findCourseInstanceById(long id){
        return courseInstanceRepository.findById(id).get();
    }

    public CourseSpecification findCourseSpecificationById(long id){
        return courseSpecificationRepository.findById(id).get();
    }

}
