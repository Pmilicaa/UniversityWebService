import { LEADING_TRIVIA_CHARS } from '@angular/compiler/src/render3/view/template';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import Enrollment from 'src/app/models/Enrollment';
import { EventServiceService } from 'src/app/services/event-service.service';

@Component({
  selector: '[app-exam-row]',
  templateUrl: './exam-row.component.html',
  styleUrls: ['./exam-row.component.css']
})
export class ExamRowComponent implements OnInit {

  @Input() enrollment;
  @Input() index;

  constructor(private eventService: EventServiceService) { }

  ngOnInit(): void {
  }

  onEnrollmentSelect(){
    console.log("called")
    this.eventService.emitExamDetailsEvent(this.enrollment);
  }

}
