import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-exam-part-table',
  templateUrl: './exam-part-table.component.html',
  styleUrls: ['./exam-part-table.component.css']
})
export class ExamPartTableComponent implements OnInit {

  @Input() examParts;

  constructor() { }

  ngOnInit(): void {
  }

}
