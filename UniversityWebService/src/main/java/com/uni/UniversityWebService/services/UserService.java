package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.model.dto.RegisterExamDto;
import com.uni.UniversityWebService.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeachingRepository teachingRepository;

    @Autowired
    private CourseSpecificationRepository courseSpecificationRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUsername(String username){
        return userRepository.findByUserName(username);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public User saveUser(User user) {
        userRepository.save(user);

        return user;
    }

    public List<Teacher> findAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
        return teacher;
    }
    public List<RegisterExamDto> getAllRegisterExams(){
        List<CourseSpecification>courseList=courseSpecificationRepository.findAll();
        List<Teaching> teachingList=teachingRepository.findAll();
        List<RegisterExamDto>registerExamDtos= new ArrayList<>();

        for(Teaching t : teachingList){


            for (ExamPart ep : t.getExam().getExamParts()){
                RegisterExamDto registerExamDto=new RegisterExamDto();
                registerExamDto.setTeacher(t.getTeacher().getLastName()+" "+t.getTeacher().getFirstName());
                registerExamDto.setCourse(t.getCourseSpecification().getTitle());
                registerExamDto.setPrice(200);
                registerExamDto.setClassroom(ep.getClassroom());
                registerExamDto.setExamDateTime(ep.getExamPartStartDate());

                registerExamDtos.add(registerExamDto);
            }



        }
        Set<RegisterExamDto> hSetReg= new HashSet<>(registerExamDtos);
        List<RegisterExamDto> returnList=new ArrayList<>(hSetReg);
        return returnList;
    }


    public User updateUser(User user){
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());

        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public Teacher updateTeacher(Teacher teacher){
        Teacher teacherToUpdate = teacherRepository.findById(teacher.getId()).get();
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setLastName(teacher.getLastName());
        teacherToUpdate.setTeachings(teacher.getTeachings());

        teacherRepository.save(teacherToUpdate);

        return teacherToUpdate;
    }

    
    public void deleteUser(User user) {
    	userRepository.delete(user);
    }

    public void deleteTeacher(Teacher teacher){
        Teacher teacherToDelete = teacherRepository.findById(teacher.getId()).get();
        teacherRepository.delete(teacherToDelete);


    }
}
