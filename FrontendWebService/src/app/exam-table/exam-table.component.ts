import { Component, OnInit } from '@angular/core';
import {Exam} from '../models/Exam'

@Component({
  selector: 'app-exam-table',
  templateUrl: './exam-table.component.html',
  styleUrls: ['./exam-table.component.css']
})
export class ExamTableComponent implements OnInit {

  constructor() { }
  exams:Exam[]=[
    {id:1,name:'Web programiranje'},
    {id:2,name: 'Baza podataka'},
    {id:3,name:'Internet mreze'},
    {id:4,name: 'Asembler'}
  ]
  ngOnInit(): void {
  }

}
