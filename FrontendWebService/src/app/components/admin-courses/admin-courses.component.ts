import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/Course';
import { AdminCoursesServiceService } from 'src/app/services/admin-courses-service.service';

@Component({
  selector: 'app-admin-courses',
  templateUrl: './admin-courses.component.html',
  styleUrls: ['./admin-courses.component.css']
})
export class AdminCoursesComponent implements OnInit {

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
