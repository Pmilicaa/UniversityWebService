import { Component, OnInit } from '@angular/core';
import { CourseInstance } from '../models/CourseInstanse';
import { CourseSpecification } from '../models/CourseSpecification';
import { Student } from '../models/Student';
import { CourseServiceService } from '../services/course-service.service';

@Component({
  selector: 'app-course-table',
  templateUrl: './course-table.component.html',
  styleUrls: ['./course-table.component.css']
})
export class CourseTableComponent implements OnInit {

  constructor(private courseService : CourseServiceService) { }
  courses:CourseSpecification[];
  students: Student[]=[];
  ngOnInit(): void {
    this.courseService.getAllTeacherCourses().subscribe((courses)=>(this.courses=courses));
    
  }
  seeStudents(id: number): void {
    this.courseService.getAllTeacherStudents(id).subscribe(( students ) => {
      this.students = students;
    })
  }

}
