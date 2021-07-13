import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import ExamPart from '../models/ExamPart';
import ExamPartsAndCourses from '../models/ExamPartsAndCourses';
import {Professor} from '../models/Professor';
import { ProfessorServiceService } from '../services/professor-service.service';

@Component({
  selector: 'app-professor-exams',
  templateUrl: './professor-exams.component.html',
  styleUrls: ['./professor-exams.component.css']
})
export class ProfessorExamsComponent implements OnInit {
  professor : Professor;
  constructor(private professorService : ProfessorServiceService) { };
  title = "Exam Parts";
  examParts: ExamPartsAndCourses[];
  selectedOption: string;
  options = [
    { name: "January", value: 1 },
    { name: "February", value: 2 },
    { name: "April", value: 3 },
    { name: "July", value: 4 }
  ]
  
  ngOnInit(): void {

    this.professorService.getloggedTeacher().subscribe((professor)=>{
      this.professor=professor
      this.professorService.getTeacherExamParts(this.professor,this.selectedOption)
                           .subscribe((examParts)=>{this.examParts=examParts
      this.examParts.forEach(examPart => { 
            examPart.date=examPart.examPartStartDate.split('T')[0];
            examPart.time=examPart.examPartStartDate.split('T')[1].substring(0,8);
      });
      }
      
      );
      
    });
    
    
  }
  filterByPeriod(id: number){
    console.log(this.selectedOption)
    this.professorService.getloggedTeacher().subscribe((professor)=>{
      this.professor=professor
      this.professorService.getTeacherExamParts(this.professor,this.selectedOption)
                           .subscribe((examParts)=>{this.examParts=examParts
      this.examParts.forEach(examPart => { 
            examPart.date=examPart.examPartStartDate.split('T')[0];
            examPart.time=examPart.examPartStartDate.split('T')[1].substring(0,8);
      });
      }
      
      );
      
    });

  }
}
