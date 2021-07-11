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
    this.adminCourseService.getAll().subscribe((courses) => (this.courses = courses));
  }

  gotoDetails(id: number): void {
    this.route.navigate(['/AdminCoursesDetails', id]);
  }

}
