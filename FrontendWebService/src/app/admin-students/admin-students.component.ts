import { Component, OnInit } from '@angular/core';
import { Student } from '../models/Student';
import { AdminStudentsService } from '../services/admin-students.service';

@Component({
  selector: 'app-admin-students',
  templateUrl: './admin-students.component.html',
  styleUrls: ['./admin-students.component.css']
})
export class AdminStudentsComponent implements OnInit {

  students: Student[];

  constructor(private adminStudentService: AdminStudentsService) { }

  title = "Students"

  ngOnInit(): void {
    this.adminStudentService.getAll().subscribe((students) => (this.students = students))
  }

}
