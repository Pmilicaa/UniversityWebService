import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Enrollment from '../models/Enrollment';
import { AuthenticationServiceService } from './authentication-service.service';


@Injectable({
  providedIn: 'root'
})
export class EnrollmentServiceService {

  private readonly path = "http://localhost:8080/enrollments";

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getLoggedInStudentEnrollments(): Observable<Enrollment[]>{
    console.log("sent");
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});

    return this.http.get<Enrollment[]>(this.path + "/me", {headers: headers});
  }
}
