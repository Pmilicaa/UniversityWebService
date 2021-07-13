package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPartStatus;
import com.uni.UniversityWebService.model.ExamPartType;

import javax.persistence.*;
import java.util.Date;

public class ExamPartProfessorDto {


    private Long id;
    private Date examPartStartDate;
    private String classroom;
    private String course;

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExamPartStartDate() {
        return examPartStartDate;
    }

    public void setExamPartStartDate(Date examPartStartDate) {
        this.examPartStartDate = examPartStartDate;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }



    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + course.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ExamPartProfessorDto))
            return false;

        return this.course.equals(((ExamPartProfessorDto) obj).getCourse());

    }
}
