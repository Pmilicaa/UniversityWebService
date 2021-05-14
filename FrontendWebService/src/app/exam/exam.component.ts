import { Component, OnInit } from '@angular/core';
import {Exam} from "../models/Exam";
@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {
  exam:Exam={
    id:142,
    name:'Internet Mreze',
    dateOfregistration:'05/14/2021',
    points:100,
    grade:10
    
  }
  constructor() { }

  ngOnInit(): void {
  }

}
