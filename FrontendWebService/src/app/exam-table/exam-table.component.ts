import { Component, Input, OnInit } from '@angular/core';
import Enrollment from '../models/Enrollment';
import {Exam} from '../models/Exam';


@Component({
  selector: 'app-exam-table',
  templateUrl: './exam-table.component.html',
  styleUrls: ['./exam-table.component.css']
})
export class ExamTableComponent implements OnInit {

  @Input() enrollments: Enrollment[];
  @Input() onEnrollmentSelect: (id: number) => void;
  constructor() { }
  

  ngOnInit(): void {
  }

}
