import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminStudentsService {

  private readonly URL = "http://localhost:8080/students";

  

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) {}

  getAll(): Observable<Student[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.get<Student[]>(this.URL, requestOptions);
  }

  saveStudent(student: Student) {
    return this.http.post(this.URL, student);
  }

}
