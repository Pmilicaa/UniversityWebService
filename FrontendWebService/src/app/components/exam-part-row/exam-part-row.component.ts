import { Component, Input, OnInit } from '@angular/core';
import ExamPart from 'src/app/models/ExamPart';
import { ExamPartService } from 'src/app/services/exam-part.service';

@Component({
  selector: '[app-exam-part-row]',
  templateUrl: './exam-part-row.component.html',
  styleUrls: ['./exam-part-row.component.css']
})
export class ExamPartRowComponent implements OnInit {

  @Input() examPart: ExamPart;
  @Input() index;

  constructor(private examPartService: ExamPartService) { }

  ngOnInit(): void {
  }

  registerExam(id: number): void {
    this.examPartService.registerExamPart(id).subscribe(( examPart ) => {
      this.examPart = examPart;
    })
  }

}
