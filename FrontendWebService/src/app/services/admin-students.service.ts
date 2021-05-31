import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminStudentsService {

  private readonly URL_STUDENTS = "http://localhost:8080/students";
  private readonly URL_API_STUDENTS = "http://localhost:8080/api/students";

  private refreshNeeded = new Subject<void>();


  constructor(private http: HttpClient, private authService: AuthenticationServiceService) {}

  getRefresNeeded() {
    return this.refreshNeeded;
  }

  getAll(): Observable<Student[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.get<Student[]>(this.URL_STUDENTS, requestOptions);
  }

  saveStudent(student: Student): Observable<Student> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const data = JSON.stringify(student)
    return this.http.post<Student>(this.URL_API_STUDENTS, data, requestOptions)
      .pipe(
          tap(() => {this.refreshNeeded.next();
          })
    );
  }

  getStudent(id: number): Observable<HttpResponse<Student>> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_STUDENTS}/${id}`;
    return this.http.get<HttpResponse<Student>>(url, requestOptions);
  }

  deleteStudent(studentId: number): Observable<any> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL_STUDENTS}/${studentId}`;
    return this.http.delete<any>(url, requestOptions);
  }

}
