import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../models/Student';
import { User } from '../models/User';
import { AdminStudentsService } from '../services/admin-students.service';

@Component({
  selector: 'app-admin-students',
  templateUrl: './admin-students.component.html',
  styleUrls: ['./admin-students.component.css']
})
export class AdminStudentsComponent implements OnInit {

  students: Student[];

  stud: Student;

  private readonly ROLE_STUDENT = "ROLE_STUDENT";
  
  constructor(private adminStudentService: AdminStudentsService, private route: Router, private location: Location, private activateRoute: ActivatedRoute) { 
  }  

  addStudent(form: NgForm): void {
    this.stud = new Student ({
      firstName: form.value.firstname,
      lastName: form.value.lastname,
      balance: +form.value.balance,
      cardNumber: form.value.cardnumber,
      accountNumber: +form.value.accountnumber,
      user: new User({
        userName: form.value.username,
        password: form.value.password,
        role: this.ROLE_STUDENT
      }),
    });
    this.adminStudentService.saveStudent(this.stud).subscribe(() => this.route.navigate(["adminStudents"]));
    console.log(form.value);
  }

  // editStud(id: number) {
  //   this.adminStudentService.getStudent(this.activateRoute.params['id'])
  //       .subscribe(res => 
  //         this.stu = res.body);
  // }
    
  title = "Studenti"

  ngOnInit(): void {
    this.adminStudentService.getRefresNeeded().subscribe(() => this.getAllStudets());
    this.getAllStudets();
  }

  private getAllStudets() {
    this.adminStudentService.getAll().subscribe((students) => (this.students = students));
  }

  deleteStudent(studentId: number): void {
    this.adminStudentService.deleteStudent(studentId).subscribe(() => this.getAllStudets());
  }

  gotoEdit(id: number): void {
    this.route.navigate(['/adminEditStudents', id]);
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

  goBack(): void {
    this.location.back();
  }

}
