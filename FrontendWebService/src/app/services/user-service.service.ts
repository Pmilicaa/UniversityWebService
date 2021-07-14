import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from './authentication-service.service';
import { User } from "../models/User";
import AdminExamRegistry from '../models/AdminExamRegistry';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private readonly URL = "http://localhost:8080/users";
  private readonly URL2 = "http://localhost:8080/examRegistery";

  constructor(private http: HttpClient,private authService: AuthenticationServiceService) { }

  getAll():Observable<User[]> {
    return this.http.get<User[]>(this.URL);
  }

  getAllExamRegistrys(): Observable<AdminExamRegistry[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
      
    };
    return this.http.get<AdminExamRegistry[]>(this.URL2,requestOptions);
  }
  getAllExamRegistrysPeriod(selcetedPeriod:String): Observable<AdminExamRegistry[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
      
    };
    const url=`${this.URL2}/${selcetedPeriod}`
    return this.http.get<AdminExamRegistry[]>(url,requestOptions);
  }
  editExamPartRegistry(adminExamRegistry:AdminExamRegistry):Observable<AdminExamRegistry>{
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.put<AdminExamRegistry>(this.URL2,adminExamRegistry,requestOptions)
  }

}
