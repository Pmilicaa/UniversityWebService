import { Component, OnInit } from '@angular/core';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { DocumentServiceService } from '../services/document-service.service';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  student: Student;

  constructor(private studentService: StudentServiceService, private authentiactionService: AuthenticationServiceService) { }

  ngOnInit(): void {
    console.log(JSON.parse(localStorage.getItem("currentUser")));
  }

}
