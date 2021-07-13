import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExamRegistration } from '../models/ExamRegistration';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class ExamRegistrationService {
  
  private readonly path = "http://localhost:8080/examRegistrations";

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getLoggedInStudentRegistrations(): Observable<ExamRegistration[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

    return this.http.get<ExamRegistration[]>(this.path + "/me", {headers: headers});
  }
}