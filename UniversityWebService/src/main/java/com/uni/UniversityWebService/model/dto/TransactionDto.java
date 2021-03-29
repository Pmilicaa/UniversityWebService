package com.uni.UniversityWebService.model.dto;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDto {


		private Long id;
		private Integer amount;
		private TransactionType transactionType;
		private Long studentId;




}
