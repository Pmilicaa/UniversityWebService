package com.uni.UniversityWebService.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.dto.ExamDto;
import com.uni.UniversityWebService.services.ExamPeriodService;
import com.uni.UniversityWebService.services.ExamService;

@RestController
@RequestMapping(value = "examPeriods/{examPeriodId}/exams")
public class ExamController {

	@Autowired
	ExamService examService;
	
	
	@GetMapping
	public ResponseEntity<List<ExamDto>> getAllExamsByExamPeriod(@PathVariable("examPeriodId") Long idExamPeriod) {
		List<Exam> exams = examService.findExamsByExamPeriod(idExamPeriod);
		List<ExamDto> examsDto = new ArrayList<ExamDto>();
		for(Exam exam : exams) {
			examsDto.add(new ExamDto(exam));
		}
		return new ResponseEntity<List<ExamDto>>(examsDto, HttpStatus.OK);
	}
	
	@GetMapping(value =  "/{examId}")
	public ResponseEntity<ExamDto> getExam(@PathVariable("examId") Long idExam) {
		Exam exam = examService.findOne(idExam);
		if(exam == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExamDto>(new ExamDto(exam), HttpStatus.OK);
	}
	
	//TODO: POST, PUT and DELETE!
}
