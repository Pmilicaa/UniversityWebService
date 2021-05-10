import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import User from "../models/User";

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private readonly URL = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  getAll():Observable<User[]> {
    return this.http.get<User[]>(this.URL);
  }
}
