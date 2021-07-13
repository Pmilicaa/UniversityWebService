import { Component, Input, OnInit } from '@angular/core';
import Enrollment from 'src/app/models/Enrollment';
import ExamPart from 'src/app/models/ExamPart';
import { ExamPartService } from 'src/app/services/exam-part.service';

@Component({
  selector: '[app-exam-part-row]',
  templateUrl: './exam-part-row.component.html',
  styleUrls: ['./exam-part-row.component.css']
})
export class ExamPartRowComponent implements OnInit {

  @Input() examPart: ExamPart;
  @Input() selectedEnrollment: Enrollment;
  @Input() index;

  constructor(private examPartService: ExamPartService) { }

  ngOnInit(): void {
  }

  registerExam(id: number, enrollmentId: number): void {
    this.examPartService.registerExamPart(id, enrollmentId).subscribe(( examPart ) => {
      this.examPart = examPart;
    })
  }

  cancelExam(id: number): void {
    this.examPartService.cancelExamPart(id).subscribe((examPart) => {
      this.examPart = examPart;
    })
  }

}
