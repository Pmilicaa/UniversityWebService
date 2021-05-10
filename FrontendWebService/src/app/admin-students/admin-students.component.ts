import { Component, OnInit } from '@angular/core';
import { Student } from '../models/Student';

@Component({
  selector: 'app-admin-students',
  templateUrl: './admin-students.component.html',
  styleUrls: ['./admin-students.component.css']
})
export class AdminStudentsComponent implements OnInit {

  students: Student[];

  constructor() { }

  title = "Students"

  ngOnInit(): void {
    this.students = [
      {
        id: 1,
        firstName: "Milica",
        lastName: "Pajic",
        cardNumber: "SF-10-2018",
        balance: 15000,
        accountNumber: 423756547967
      },
      {
        id: 2,
        firstName: "Damir",
        lastName: "Tizmonar",
        cardNumber: "SF-12-2018",
        balance: 1000,
        accountNumber: 3883833
      },
      {
        id: 3,
        firstName: "Aleksa",
        lastName: "Petrovic",
        cardNumber: "12313rfr35y24ygw3r5325",
        balance: 15000,
        accountNumber: 423756547967 
      }
    ]
    
  }

}
