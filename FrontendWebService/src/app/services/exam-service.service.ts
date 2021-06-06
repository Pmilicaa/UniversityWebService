import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from '../models/Exam';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class ExamServiceService {

  private readonly path = "http://localhost:8080/exams";

  constructor(private http: HttpClient, private examService: ExamServiceService,
    private authService: AuthenticationServiceService) { }

  getLoggedInStudentExams(): Observable<Exam[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

    return this.http.get<Exam[]>(this.path + "/me", {headers: headers});
  }


}
