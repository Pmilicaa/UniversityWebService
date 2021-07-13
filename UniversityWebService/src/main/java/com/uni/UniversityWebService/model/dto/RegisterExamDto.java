package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.ExamPeriod;

import java.util.Date;

public class RegisterExamDto {

            private String course;
            private Date examDateTime;
            private int price;
            private String teacher;
            private String classroom;
            private ExamPeriod examPeriod;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getExamDateTime() {
        return examDateTime;
    }

    public void setExamDateTime(Date examDateTime) {
        this.examDateTime = examDateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ExamPeriod getExamPeriod() {
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriod examPeriod) {
        this.examPeriod = examPeriod;
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
        if (!(obj instanceof RegisterExamDto))
            return false;

        return this.course == ((RegisterExamDto) obj).getCourse();


    }
}
