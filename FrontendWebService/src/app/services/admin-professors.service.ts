import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professor } from '../models/Professor';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminProfessorsService {

  private readonly URL = "http://localhost:8080/teachers";

  constructor(private http: HttpClient,private authService: AuthenticationServiceService) { }

  getAll(): Observable<Professor[]> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.get<Professor[]>(this.URL,requestOptions);
  }
  addTeacher(profesor:Professor): Observable<Professor>{
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.post<Professor>(this.URL,profesor,requestOptions);
  }
  editTeacher(profesor:Professor):Observable<Professor>{
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    return this.http.put<Professor>(this.URL,profesor,requestOptions)
  }
  deleteTeacher(profesor:Professor): Observable<any> {
    const headInfo = {
      'Content-Type': 'application/json',
      'X-Auth-Token': "" + this.authService.getToken()
      
    }
    const requestOptions = {
      headers: new HttpHeaders(headInfo)
    };
    const url = `${this.URL}/${profesor.id}`;
    return this.http.delete<any>(url, requestOptions);
  }

}
