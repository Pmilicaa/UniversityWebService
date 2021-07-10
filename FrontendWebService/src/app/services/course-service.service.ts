import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CourseInstance } from '../models/CourseInstanse';
import { CourseSpecification } from '../models/CourseSpecification';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from './authentication-service.service';


@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

  private readonly path = "http://localhost:8080/teachers/courses"

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getAllTeacherCourses(): Observable<CourseSpecification[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
  
    return this.http.get<CourseSpecification[]>(this.path, {headers: headers});
  }
  getAllTeacherStudents(id : number): Observable<Student[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<Student[]>("http://localhost:8080/teachers/courses/"+ id +"/students", {headers: headers});

  }

}
