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

  student: Student

  constructor(private adminStudentService: AdminStudentsService) { 
    // this.student = new Student ({
    //   firstName: '',
    //   lastName: '',
    //   cardNumber: '',
    //   balance: 0,
    //   accountNumber: 0
    // });
  }

  title = "Students"

  ngOnInit(): void {
    this.adminStudentService.getAll().subscribe((students) => (this.students = students))
  }

  public showAddStudent(): void {
    let x = document.getElementById("addStudent");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }

  public showEditStudent(): void {
    let x = document.getElementById("editStudent");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }

  // public add(): void {
  //   this.adminStudentService.saveStudent(this.student);
  // }

}
