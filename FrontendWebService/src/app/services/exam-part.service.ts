import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import ExamPart from '../models/ExamPart';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class ExamPartService {

  private readonly path = "http://localhost:8080/examParts";

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  registerExamPart(id: number): Observable<ExamPart>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
  
    return this.http.post<ExamPart>(this.path + "/register/" + id, {}, {headers: headers});
  }

  cancelExamPart(id: number): Observable<ExamPart>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
  
    return this.http.post<ExamPart>(this.path + "/cancel/" + id, {}, {headers: headers});
  }
}
