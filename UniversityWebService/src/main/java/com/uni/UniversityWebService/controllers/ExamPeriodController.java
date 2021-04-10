package com.uni.UniversityWebService.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uni.UniversityWebService.model.ExamPeriod;
import com.uni.UniversityWebService.model.dto.ExamPeriodDto;
import com.uni.UniversityWebService.services.ExamPeriodService;

@RestController
public class ExamPeriodController {

	@Autowired
	ExamPeriodService examPeriodService;
	
	@GetMapping(value = "examPeriods")
	public ResponseEntity<List<ExamPeriodDto>> getAllExamPeriods() {
		List<ExamPeriod> examPeriods = examPeriodService.findAll();
		List<ExamPeriodDto> examPeriodsDto = new ArrayList<ExamPeriodDto>();
		for(ExamPeriod ep : examPeriods) {
			examPeriodsDto.add(new ExamPeriodDto(ep));
		}
		return new ResponseEntity<List<ExamPeriodDto>>(examPeriodsDto, HttpStatus.OK); 
	}
	
	@GetMapping(value = "examPeriods/{id}")
	public ResponseEntity<ExamPeriodDto> getExamPeriod(@PathVariable("id") Long id) {
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null) {
			return new ResponseEntity<ExamPeriodDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExamPeriodDto>(new ExamPeriodDto(examPeriod), HttpStatus.OK);
	}
	
	//POST and PUT I think methods is not nedded because the data will aleready be in the database(we will enter them manually) - Check with the rest of the team
	
	@DeleteMapping(value = "examPeriods/{id}")
	public ResponseEntity<Void> deleteExamPeriod(@PathVariable("id") Long id) {
		ExamPeriod examPeriod = examPeriodService.findOne(id);
		if(examPeriod == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		examPeriodService.remove(examPeriod);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
