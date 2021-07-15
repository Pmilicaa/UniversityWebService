import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Professor } from '../models/Professor';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from './authentication-service.service';
import ExamPartsAndCourses from '../models/ExamPartsAndCourses';
import { Student } from '../models/Student';
import { Exam } from '../models/Exam';
import ExamPart from '../models/ExamPart';


@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {

  private readonly path = "http://localhost:8080/teachers";

  constructor(private http: HttpClient, private authService : AuthenticationServiceService) { }

  getTeachers(): Observable<Professor>{
    return this.http.get<Professor>(this.path);
  }
  getloggedTeacher(): Observable<Professor>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

    return this.http.get<Professor>(this.path + "/me", {headers: headers});
  }
  getTeacherExamParts(professor:Professor,period: String): Observable<ExamPartsAndCourses[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    const url = `${this.path}/${professor.id}/examPartsAndSpec/${period}`;
    return this.http.get<ExamPartsAndCourses[]>(url, {headers: headers});
  }
  getRegisteredStudent(course : String): Observable<Student[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<Student[]>("http://localhost:8080/teachers/registeredStudentsForExam/" + course, {headers: headers});

  }
  getExamPartStudentForGrade(id : number, courseSpec : string): Observable<ExamPart[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<ExamPart[]>("http://localhost:8080/teachers/student/" + id + "/" + courseSpec, {headers: headers});
  }
  getExamPartWithPoints(id : number, inputValue : string): Observable<ExamPart>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<ExamPart>("http://localhost:8080/teachers/examParts/" + id + "/" + inputValue, {headers: headers});
  }
}

