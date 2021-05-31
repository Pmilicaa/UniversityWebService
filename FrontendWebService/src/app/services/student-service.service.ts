import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private readonly path = '/students';

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getLoggedInStudent(): Observable<Student>{
    return this.http.get<Student>(this.path);
  }

  getMe(): Observable<Student>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

    return this.http.get<Student>(this.path + "/me", {headers: headers});
  }

}
