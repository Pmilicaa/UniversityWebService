import { Component, OnInit } from '@angular/core';
import { Professor } from '../models/Professor';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { DocumentServiceService } from '../services/document-service.service';
import { ProfessorServiceService } from '../services/professor-service.service';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-professor-profile',
  templateUrl: './professor-profile.component.html',
  styleUrls: ['./professor-profile.component.css']
})
export class ProfessorProfileComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }

}
