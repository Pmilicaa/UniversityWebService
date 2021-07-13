import { Component, OnInit } from '@angular/core';
import Enrollment from 'src/app/models/Enrollment';
import { Exam } from 'src/app/models/Exam';
import { ExamRegistration } from 'src/app/models/ExamRegistration';
import { EnrollmentServiceService } from 'src/app/services/enrollment-service.service';
import { EventServiceService } from 'src/app/services/event-service.service';
import { ExamRegistrationService } from 'src/app/services/exam-registration.service';

@Component({
  selector: 'app-exams',
  templateUrl: './exams.component.html',
  styleUrls: ['./exams.component.css']
})
export class ExamsComponent implements OnInit {

  enrollments:Enrollment[] = [];
  exams:Exam[] = [];
  examRegistrations: ExamRegistration[] = [];

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

  constructor(private enrollmentService: EnrollmentServiceService, private eventService: EventServiceService,
              private examRegistrationService: ExamRegistrationService) { }

  ngOnInit(): void {
    this.enrollmentService.getLoggedInStudentEnrollments().subscribe( (enrollments) => {
      this.enrollments = enrollments
      this.exams = this.getExamsFromEnrollments(enrollments);
    });
    this.eventService.examDetailsListener().subscribe( (enrollment) => {
      this.selectedEnrollment = enrollment;
    });
    this.examRegistrationService.getLoggedInStudentRegistrations().subscribe( (examRegistrations) => {
      this.examRegistrations = examRegistrations;
    })
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