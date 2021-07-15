package com.uni.UniversityWebService.services;


import com.uni.UniversityWebService.model.*;

import com.uni.UniversityWebService.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {


    @Autowired
    CourseSpecificationRepository courseSpecificationRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ExamPartRepository examPartRepository;

    @Autowired
    ExamPeriodRepository examPeriodRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeachingRepository teachingRepository;

    @Autowired
    TeachingTypeRepository teachingTypeRepository;

    @Autowired
    ExamPartTypeRepository examPartTypeRepository;

    @Autowired
    ExamPartStatusRepository examPartStatusRepository;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    CourseInstanceRepository courseInstanceRepository;

    public CourseInstance saveCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public CourseSpecification saveCourseSpecification(CourseSpecification courseSpecification,String teacher) {
        List<Enrollment> enrollments= new ArrayList<>();
        List<Student> students=studentRepository.findAll();
        courseSpecificationRepository.save(courseSpecification);
        List<ExamPeriod> eps=examPeriodRepository.findAll();
        List<Teacher> teachers=teacherRepository.findAll();
        List<ExamPartType> examPartTypes=examPartTypeRepository.findAll();
        ExamPeriod ep=eps.get(1);
        List<TeachingType>tts= teachingTypeRepository.findAll();
        ExamPartStatus examPartStatuses=examPartStatusRepository.findByCode("N");
        TeachingType teachingType=tts.get(0);
        for(Student s:students){
            Set<ExamPart> examPartSet=new HashSet<>();
            for(ExamPartType ept:examPartTypes){

                ExamPart examPart= new ExamPart();
                examPart.setExamPartStartDate(new Date("20/1/2021"));
                examPart.setClassroom("200");
                examPart.setExamPartPoints(0);
                examPart.setExamPartType(ept);
                examPart.setExamPartStatus(examPartStatuses);
                examPart.setRequiredPoints(25);
                examPartSet.add(examPart);
                examPartRepository.save(examPart);
            }
            Exam exam=new Exam();
            exam.setExamPoints(0);
            exam.setGrade(0);
            exam.setExamPeriod(ep);
            exam.setExamParts(examPartSet);
            examRepository.save(exam);
            Enrollment enrollment= new Enrollment();
            enrollment.setCourseSpecification(courseSpecification);
            enrollment.setExam(exam);
            enrollment.setStudent(s);
            enrollmentRepository.save(enrollment);
            }

        for (Teacher t:teachers) {
            Set<ExamPart> examPartSet=new HashSet<>();
            if(t.getFirstName().equals(teacher)){
            Teaching teaching = new Teaching();
            teaching.setCode("M");
                for(ExamPartType ept:examPartTypes){

                    ExamPart examPart= new ExamPart();
                    examPart.setExamPartStartDate(new Date("20/1/2021"));
                    examPart.setClassroom("200");
                    examPart.setExamPartPoints(0);
                    examPart.setExamPartType(ept);
                    examPart.setExamPartStatus(examPartStatuses);
                    examPart.setRequiredPoints(25);
                    examPartSet.add(examPart);
                    examPartRepository.save(examPart);
                }
            Exam exam = new Exam();
            exam.setExamPoints(0);
            exam.setGrade(0);
            exam.setExamPeriod(ep);
            exam.setExamParts(examPartSet);
            examRepository.save(exam);
            teaching.setExam(exam);
            teaching.setTeacher(t);
            teaching.setTeachingType(teachingType);
            teaching.setCourseSpecification(courseSpecification);
            teachingRepository.save(teaching);

        }}
        return courseSpecification;
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

    public CourseSpecification addNewCourse(CourseSpecification courseSpecification){

        courseSpecificationRepository.save(courseSpecification);




        return courseSpecification;
    }

}
