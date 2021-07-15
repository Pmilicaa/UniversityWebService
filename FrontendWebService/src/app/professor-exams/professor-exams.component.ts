import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Exam } from '../models/Exam';
import ExamPart from '../models/ExamPart';
import ExamPartsAndCourses from '../models/ExamPartsAndCourses';
import {Professor} from '../models/Professor';
import { Student } from '../models/Student';
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
  students: Student[]=[];
  examParts: ExamPartsAndCourses[];
  examParts1: ExamPart[]=[];
  examPart : ExamPart;
  exams : Exam[]=[];
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
  seeRegisteredStudent(course : String){
    (<HTMLInputElement>document.getElementById("selectedCourse")).value = <string>course;
    this.professorService.getRegisteredStudent(course).subscribe(( students ) => {
      this.students = students;
    })
  }
  getStudentExamPart(id : number){
    var courseSpec = (<HTMLInputElement>document.getElementById("selectedCourse")).value;
    this.professorService.getExamPartStudentForGrade(id, courseSpec).subscribe(( examParts1 ) => {
      this.examParts1 = examParts1;
    })
    console.log(this.examParts)
  }
  
  gradeStudent(id : number){
    var inputValue = (<HTMLInputElement>document.getElementById("gradeInput")).value;
    this.professorService.getExamPartWithPoints(id, inputValue).subscribe(( examPart ) => {
      this.examPart = examPart;
    })
  }
}
