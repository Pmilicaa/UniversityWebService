import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CourseInstance } from 'src/app/models/CourseInstanse';
import { Professor } from 'src/app/models/Professor';
import { AdminCoursesServiceService } from 'src/app/services/admin-courses-service.service';

@Component({
  selector: 'app-admin-courses-details',
  templateUrl: './admin-courses-details.component.html',
  styleUrls: ['./admin-courses-details.component.css']
})
export class AdminCoursesDetailsComponent implements OnInit {

  id: number;
  professors: Professor[];
  courseInstances: CourseInstance[];  


  title ="Details for course";
  endDateMessage = "Active"

  constructor(private adminCourseService: AdminCoursesServiceService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getCI();
    console.log(this.courseInstances);
  }

  getCI() {
    this.id=+this.activatedRoute.snapshot.params["id"];
    this.adminCourseService.getTeachersByCourse(this.id)
    .subscribe(professors => {
      this.professors = professors;
      this.adminCourseService.getCourseInstancesByCourse(this.id)
      .subscribe((courseInstances) => { 
      this.courseInstances = courseInstances
      console.log(this.courseInstances);
      });
    });
  }

}
