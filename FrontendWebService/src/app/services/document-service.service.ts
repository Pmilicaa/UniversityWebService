import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import Document from "../models/Document";

@Injectable({
  providedIn: 'root'
})
export class DocumentServiceService {

  private readonly URL = "http://localhost:8080/documents";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Document[]>{
      return this.http.get<Document[]>(this.URL);
  }
}
