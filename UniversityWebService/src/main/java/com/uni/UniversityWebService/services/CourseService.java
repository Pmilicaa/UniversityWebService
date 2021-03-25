package com.uni.UniversityWebService.services;


import com.uni.UniversityWebService.model.CourseInstance;

import com.uni.UniversityWebService.model.CourseSpecification;
import com.uni.UniversityWebService.repositories.CourseInstanceRepository;
import com.uni.UniversityWebService.repositories.CourseSpecificationRepository;
import com.uni.UniversityWebService.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {


    @Autowired
    CourseSpecificationRepository courseSpecificationRepository;


    @Autowired
    CourseInstanceRepository courseInstanceRepository;

    public CourseInstance InstanceUpdate(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public CourseSpecification SpecUpdate(CourseSpecification courseSpecification) {
        return courseSpecificationRepository.save(courseSpecification);
    }

}
