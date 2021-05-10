package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.model.Transaction;
import com.uni.UniversityWebService.model.dto.TransactionDto;
import com.uni.UniversityWebService.repositories.StudentRepository;
import com.uni.UniversityWebService.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

//              witdraw u frontu
	@Autowired
    private  TransactionRepository transactionRepository;
	@Autowired
    private  StudentRepository studentRepository;

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

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }




}
