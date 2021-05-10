import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../models/Student';

@Injectable({
  providedIn: 'root'
})
export class AdminStudentsService {

  private readonly URL = "http://localhost:8080/students";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.URL);
  }

}
