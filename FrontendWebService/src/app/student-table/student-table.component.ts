import { Component, OnInit } from '@angular/core';
import {Student} from '../models/Student';
import {Exam} from '../models/Exam';
@Component({
  selector: 'app-student-table',
  templateUrl: './student-table.component.html',
  styleUrls: ['./student-table.component.css']
})
export class StudentTableComponent implements OnInit {

  constructor() { }
  exams:Exam[]=[
    {id:1,name:'Web programiranje',dateOfregistration:'2020-02-02', points: 100, grade:10},
    {id:2,name: 'Baza podataka' ,dateOfregistration:'2020-04-02', points: 99, grade:10},
    {id:3,name:'Internet mreze',dateOfregistration:'2020-06-02', points: 100, grade:10},
    {id:4,name: 'Asembler',dateOfregistration:'2020-07-02', points: 100, grade:10}
  ];
  students:Student[]=[
    {
      id: 1,
      firstName: "Aleksa",
      lastName: "Petrovic",
      cardNumber: "12313rfr35y24ygw3r5325",
      balance: 15000,
      accountNumber: 423756547967,
      user: {
        userName: "aleksa123",
        password:"asdasd",
        role: "ROLE_STUDENT"
      }
    },
    {
      id: 1,
      firstName: "Milica",
      lastName: "Pajic",
      cardNumber: "345yuikj4567890g",
      balance: 15000,
      accountNumber: 234567890,
      user: {
        userName: "aleksa123",
        password:"asdasd",
        role: "ROLE_STUDENT"
      }
    },


   ]
  ngOnInit(): void {
  }

}
