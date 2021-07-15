import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../models/Course';
import { CourseInstance } from '../models/CourseInstanse';
import { CourseSpecification } from '../models/CourseSpecification';
import { Professor } from '../models/Professor';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminCoursesServiceService {

  private readonly URL_COURSES = "http://localhost:8080/courses";

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getAll(): Observable<Course[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.get<Course[]>(this.URL_COURSES, requestOptions);
  }

  getCourse(courseId: number): Observable<Course> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${courseId}`
    return this.http.get<Course>(url, requestOptions);
  }

  getTeachersByCourse(courseId: number): Observable<Professor[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${courseId}/teachers`
    return this.http.get<Professor[]>(url, requestOptions);
  }

  getCourseInstancesByCourse(courseId: number): Observable<CourseInstance[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${courseId}/courseInstances`
    return this.http.get<CourseInstance[]>(url, requestOptions);
  }

  updateCourse(courseId: number, course: Course): Observable<Course> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${courseId}`
    return this.http.put<Course>(url, course, requestOptions);
  }

  deleteCourse(courseId: number): Observable<any> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${courseId}`;
    return this.http.delete<any>(url, requestOptions);
  }

  addCourse(courseSpec:CourseSpecification,id: String){
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_COURSES}/${id}`;
    return this.http.post<any>(url,courseSpec, requestOptions);

  }

}
