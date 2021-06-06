import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: '[app-exam-part-row]',
  templateUrl: './exam-part-row.component.html',
  styleUrls: ['./exam-part-row.component.css']
})
export class ExamPartRowComponent implements OnInit {

  @Input() examPart;
  @Input() index;

  constructor() { }

  ngOnInit(): void {
  }

  registerExam(): void {
    
  }

}
