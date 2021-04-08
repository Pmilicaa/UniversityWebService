package com.uni.UniversityWebService.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPeriod;

public class ExamPeriodDto {

	private Long id;
	private String name;
	private Date examPeriodStartDate;
	private Date examPeriodEndDate;
	private Set<ExamDto> examsDto;
	
	public ExamPeriodDto() {
		
	}
	
	public ExamPeriodDto(ExamPeriod examPeriod) {
		this.id = examPeriod.getId();
		this.name = examPeriod.getName();
		this.examPeriodStartDate = examPeriod.getExamPeriodStartDate();
		this.examPeriodEndDate = examPeriod.getExamPeriodEndDate();
		this.examsDto = convertExamToDtos(examPeriod.getExams());
	}
	
	private Set<ExamDto> convertExamToDtos(Set<Exam> exams) {
		Set<ExamDto> examsDtos = new HashSet<ExamDto>();
		for(Exam exam : exams) {
			examsDtos.add(new ExamDto(exam));
		}
		return examsDtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExamPeriodStartDate() {
		return examPeriodStartDate;
	}

	public void setExamPeriodStartDate(Date examPeriodStartDate) {
		this.examPeriodStartDate = examPeriodStartDate;
	}

	public Date getExamPeriodEndDate() {
		return examPeriodEndDate;
	}

	public void setExamPeriodEndDate(Date examPeriodEndDate) {
		this.examPeriodEndDate = examPeriodEndDate;
	}

	public Set<ExamDto> getExamsDto() {
		return examsDto;
	}

	public void setExamsDto(Set<ExamDto> examsDto) {
		this.examsDto = examsDto;
	}
	
}
