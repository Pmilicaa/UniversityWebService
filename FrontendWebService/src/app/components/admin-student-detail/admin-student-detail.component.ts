import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Student } from 'src/app/models/Student';
import { User } from 'src/app/models/User';
import { AdminStudentsService } from 'src/app/services/admin-students.service';

@Component({
  selector: 'app-admin-student-detail',
  templateUrl: './admin-student-detail.component.html',
  styleUrls: ['./admin-student-detail.component.css']
})
export class AdminStudentDetailComponent implements OnInit {

  student: Student = {
    firstName: '',
    lastName: '',
    cardNumber: '',
    balance: +'',
    accountNumber: +'',
    user: null
  }
  id: number;

  constructor(private studentService: AdminStudentsService, private activatedRoute: ActivatedRoute, private route: Router, private location: Location) { }

  ngOnInit(): void {
      this.id=+this.activatedRoute.snapshot.params["id"];
        this.studentService.getStudent(this.id)
      .subscribe(data => {
        this.student = data});
    }  
      
  goBack(): void {
    this.location.back();
  }

  editStudent(): void {
    this.studentService.updateStudent(this.student.id, this.student).subscribe(() => this.route.navigate(["adminStudents"]));
  }
  
}
