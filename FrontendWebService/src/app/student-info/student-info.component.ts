import { Component, OnInit } from '@angular/core';
import { Student } from "../models/Student";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  student:Student = {
    id: 1,
    firstName: "Aleksa",
    lastName: "Petrovic",
    cardNumber: "12313rfr35y24ygw3r5325",
    balance: 15000,
    accountNumber: 423756547967
  }
  constructor() { }

  ngOnInit(): void {
  }

}