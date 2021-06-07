import { Component, OnInit } from '@angular/core';
import {Exam} from "../models/Exam";
import {Course} from "../models/Course";
@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {
  // exams:Exam[]=[
  //   {id:1,name:'Web programiranje',dateOfregistration:'2020-02-s02', points: 100, grade:10},
  //   {id:2,name: 'Baza podataka' ,dateOfregistration:'2020-04-02', points: 99, grade:10},
  //   {id:3,name:'Internet mreze',dateOfregistration:'2020-06-02', points: 100, grade:10},
  //   {id:4,name: 'Asembler',dateOfregistration:'2020-07-02', points: 100, grade:10}
  // ];
  // courses:Course[]=[
  //   {id:'1',title:'Matematika 1',ECTS:8,code:'SIT02D',teacher:'Gabrijela Grujic'},
  //   {id:'2',title:'Matematika 2',ECTS:8,code:'SIT08',teacher:'Mile Moler'}


  // ];
  exams:Exam[] = [];
  courses:Course[] = [];

  ngOnInit(): void {
  }

}
