import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private readonly path = '/students';

  constructor(private http: HttpClient) { }

  getLoggedInStudent(): Observable<Student>{
    return this.http.get<Student>(this.path);
  }

}
