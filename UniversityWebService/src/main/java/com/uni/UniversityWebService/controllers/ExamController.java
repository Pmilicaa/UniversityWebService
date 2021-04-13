package com.uni.UniversityWebService.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.Enrollment;
import com.uni.UniversityWebService.model.Exam;
import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.model.Teaching;
import com.uni.UniversityWebService.model.dto.ExamDto;
import com.uni.UniversityWebService.services.EnrollmentService;
import com.uni.UniversityWebService.services.ExamPeriodService;
import com.uni.UniversityWebService.services.ExamService;
import com.uni.UniversityWebService.services.TeachingService;

@RestController
@RequestMapping(value = "examPeriods/{examPeriodId}/exams")
public class ExamController {

	@Autowired
	ExamService examService;
	
	@Autowired
	ExamPeriodService examPeriodService;
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@Autowired
	TeachingService teachingService;
	
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
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExamDto> saveExam(@RequestBody ExamDto examDto, @PathVariable("examPeriodId") Long id) {
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Enrollment enrollment = enrollmentService.findOne(examDto.getEnrollmentDto().getId());
		if(enrollment == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Teaching teaching = teachingService.findOne(examDto.getTeachingDto().getId());
		if(teaching == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Exam exam = new Exam();
		exam.setEnrollment(enrollment);
		exam.setExamPeriod(examPeriod);
		exam.setGrade(examDto.getGrade());
		exam.setTeaching(teaching);
		exam.setExamPoints(examDto.getExamPoints());
		//TODO: Set List ExamPart;
		
		exam = examService.save(exam);
		return new ResponseEntity<ExamDto>(new ExamDto(exam), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{examId}", consumes = "application/json")
	public ResponseEntity<ExamDto> updateExam(@RequestBody ExamDto examDto,
											  @PathVariable("examId") Long idExam, 
											  @PathVariable("examPeriodId") Long idExamPeriod)  {
		if(!idExam.equals(examDto.getId())) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Exam exam = examService.findOne(idExam);
		if(exam == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		ExamPeriod examPeriod = examPeriodService.findOne(idExamPeriod);
		if(examPeriod == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Enrollment enrollment = enrollmentService.findOne(examDto.getEnrollmentDto().getId());
		if(enrollment == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		Teaching teaching = teachingService.findOne(examDto.getTeachingDto().getId());
		if(teaching == null) {
			return new ResponseEntity<ExamDto>(HttpStatus.BAD_REQUEST);
		}
		exam.setEnrollment(enrollment);
		exam.setExamPeriod(examPeriod);
		exam.setGrade(examDto.getGrade());
		exam.setTeaching(teaching);
		exam.setExamPoints(examDto.getExamPoints());
		//TODO: Set List ExamPart;
		
		exam = examService.save(exam);
		return new ResponseEntity<ExamDto>(new ExamDto(exam), HttpStatus.CREATED);
	}
	//TODO: DELETE!
	
	@DeleteMapping(value = "/{examId}")
	public ResponseEntity<Void> deleteExam(@PathVariable("examId") Long idExam) {
		Exam exam = examService.findOne(idExam);
		if(exam == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		examService.remove(idExam);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}