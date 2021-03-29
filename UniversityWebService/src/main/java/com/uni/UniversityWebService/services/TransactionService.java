package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Transaction;
import com.uni.UniversityWebService.model.dto.TransactionDto;
import com.uni.UniversityWebService.repositories.StudentRepository;
import com.uni.UniversityWebService.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TransactionService {

//              witdraw u frontu
    private final TransactionRepository transactionRepository;
    private final StudentRepository studentRepository;
    @Transactional
    public void addNewTransaction(TransactionDto transactionDto) throws Exception {

        Transaction transaction= new Transaction();
        Optional<Student> student= studentRepository.findById(transactionDto.getStudentId());
        Student existingStudent= new Student();
        if (student.isPresent()){
            existingStudent=student.get();

        }else{
            throw new Exception("Student with given id dosent exist");
        }
        if (transactionDto.getTransactionType().equals("Deposite")){

            existingStudent.setBalance(existingStudent.getBalance()+transactionDto.getAmount());

        }else{

            existingStudent.setBalance(existingStudent.getBalance()-transactionDto.getAmount());
        }
        studentRepository.save(existingStudent);
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setStudent(existingStudent);
        transactionRepository.save(transaction);

    }




}
