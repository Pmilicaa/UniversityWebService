import { Component, OnInit } from '@angular/core';
import {Exam} from '../models/Exam';
import {Student} from '../models/Student'


@Component({
  selector: 'app-exam-table',
  templateUrl: './exam-table.component.html',
  styleUrls: ['./exam-table.component.css']
})
export class ExamTableComponent implements OnInit {

  constructor() { }
  exams:Exam[]=[
    {id:1,name:'Web programiranje',dateOfregistration:'2020-02-02', points: 100, grade:10},
    {id:2,name: 'Baza podataka' ,dateOfregistration:'2020-04-02', points: 99, grade:10},
    {id:3,name:'Internet mreze',dateOfregistration:'2020-06-02', points: 100, grade:10},
    {id:4,name: 'Asembler',dateOfregistration:'2020-07-02', points: 100, grade:10}
  ];

  ngOnInit(): void {
  }

}
