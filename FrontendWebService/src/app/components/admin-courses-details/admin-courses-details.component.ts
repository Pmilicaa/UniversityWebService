import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/models/Course';
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
  title2: String = "Edit Course";

  course: Course = {
    title: ' ',
    ects: +' ',
    code: ' ',
    active: null
  }

  constructor(private adminCourseService: AdminCoursesServiceService, private activatedRoute: ActivatedRoute, private route: Router, private location: Location) { }

  ngOnInit(): void {
    this.getCI();
    this.getCS();
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

  getCS() {
    this.id=+this.activatedRoute.snapshot.params["id"];
    this.adminCourseService.getCourse(this.id).subscribe((course) => {this.course = course});
  }

  editCourse(): void {
    this.adminCourseService.updateCourse(this.course.id, this.course).subscribe(() => this.route.navigate(["AdminCourses"]));
  }

  goBack(): void {
    this.location.back();
  }

}
