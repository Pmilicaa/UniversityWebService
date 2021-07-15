import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/Course';
import { CourseSpecification } from 'src/app/models/CourseSpecification';
import { AdminCoursesServiceService } from 'src/app/services/admin-courses-service.service';

@Component({
  selector: 'app-admin-courses',
  templateUrl: './admin-courses.component.html',
  styleUrls: ['./admin-courses.component.css']
})
export class AdminCoursesComponent implements OnInit {
  public courseSpec:CourseSpecification= new CourseSpecification();
  courses: Course[];
  title: String = "Courses";
  
  constructor(private adminCourseService: AdminCoursesServiceService, private route: Router) { }

  ngOnInit(): void {
    this.getAllCourses();
  }

  getAllCourses(): void {
    this.adminCourseService.getAll().subscribe((courses) => (this.courses = courses));
  }

  gotoDetails(id: number): void {
    this.route.navigate(['/AdminCoursesDetails', id]);
  }

  deleteCourse(id: number): void {
    this.adminCourseService.deleteCourse(id).subscribe(() => this.getAllCourses());
  }

  addCourse(){
    console.log(this.courseSpec);
    this.adminCourseService.addCourse(this.courseSpec).subscribe((result) => {
      if(result){
        this.courseSpec=new CourseSpecification();
        
      }
    });

  }
  public showAddCourse(): void {
    let x = document.getElementById("addCourse");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }

  // showEditTeacher(id: number): void {
  //   this.gotoDetails(id);
  //   let x = document.getElementById("editCourse");
  //   if (x.style.display === "none") {
  //     x.style.display = "block";
  //   } else {
  //     x.style.display = "none";
  //   }
  // }

}
