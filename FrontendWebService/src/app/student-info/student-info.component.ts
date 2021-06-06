import { Component, OnInit } from '@angular/core';
import { Student } from "../models/Student";
import { User } from '../models/User';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  student:Student = {
    id: 0,
    firstName: "",
    lastName: "",
    cardNumber: "",
    balance: 0,
    accountNumber: 123123,
    user: {
      userName: "",
      role: "",
      password: ""
    }
  };
  
  constructor(private studentService: StudentServiceService) { }

  ngOnInit(): void {
    this.studentService.getMe().subscribe( (student) => (this.student = student));
  }

}
