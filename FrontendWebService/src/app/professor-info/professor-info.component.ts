import { Component, OnInit } from '@angular/core';
import {Professor} from '../models/Professor';
import { ProfessorServiceService } from '../services/professor-service.service';

@Component({
  selector: 'app-professor-info',
  templateUrl: './professor-info.component.html',
  styleUrls: ['./professor-info.component.css']
})
export class ProfessorInfoComponent implements OnInit {

  professor : Professor;
  constructor(private professorService : ProfessorServiceService ) { }

  ngOnInit(): void {
    this.professorService.getloggedTeacher().subscribe((professor)=>(this.professor=professor));

  }

}
