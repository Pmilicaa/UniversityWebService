package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.Role;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Teacher;
import com.uni.UniversityWebService.model.User;
import com.uni.UniversityWebService.repositories.StudentRepository;
import com.uni.UniversityWebService.repositories.TeacherRepository;
import com.uni.UniversityWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<User> findAll(){
        return userRepository.findAll();
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

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }

}
