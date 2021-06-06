import { Component, OnInit } from '@angular/core';
import Enrollment from 'src/app/models/Enrollment';
import { Exam } from 'src/app/models/Exam';
import { EnrollmentServiceService } from 'src/app/services/enrollment-service.service';
import { EventServiceService } from 'src/app/services/event-service.service';

@Component({
  selector: 'app-exams',
  templateUrl: './exams.component.html',
  styleUrls: ['./exams.component.css']
})
export class ExamsComponent implements OnInit {

  enrollments:Enrollment[] = [];
  exams:Exam[] = [];
  selectedEnrollment: Enrollment = {
    id: 0,
    exam: {
      id: 0,
      examPoints: 0,
      grade: 0,
      examParts: [],
      teaching: null
    }
  };

  constructor(private enrollmentService: EnrollmentServiceService, private eventService: EventServiceService) { }

  ngOnInit(): void {
    this.enrollmentService.getLoggedInStudentEnrollments().subscribe( (enrollments) => {
      this.enrollments = enrollments
      this.exams = this.getExamsFromEnrollments(enrollments);
    });
    this.eventService.examDetailsListener().subscribe( (enrollment) => {
      console.log(enrollment);
      console.log("logged enrollments")
      this.selectedEnrollment = enrollment;
    });
  }

  getExamsFromEnrollments(enrollments: Enrollment[]){
    var exams:Exam[] = [];

    enrollments.forEach(enrollment => {
      exams.push(enrollment.exam);
    });
    console.log(exams);
    return exams;
  }

  getEnrollmentById (id: number) {
    this.enrollments.forEach(enrollment => {
      if(enrollment.id == id){
        return enrollment;
      }
    });
    return null;
  }

}
