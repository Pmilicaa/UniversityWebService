import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';

import Document from "../models/Document";
import FileResponse from '../models/FileResponse';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class DocumentServiceService {

  private readonly URL = "http://localhost:8080/documents";

  constructor(private http: HttpClient, private authService: AuthenticationServiceService) { }

  getAll(): Observable<Document[]>{
    return this.http.get<Document[]>(this.URL);
  }

<<<<<<< HEAD
  getLoggedInUserDocuments(): Observable<Document[]>{
    const headers = new HttpHeaders({"Content-Type": "application/json", "X-Auth-Token": this.authService.getToken().toString()});
    return this.http.get<Document[]>(this.URL + "/me", {headers: headers});
  }

  uploadDocument(): Observable<Document> {
=======
  uploadDocument(): Observable<FileResponse> {
    console.log("called");
>>>>>>> 3f8fe5d1f46b9766c89d40e6ec5dcc27b52a1ae4
    const headers = new HttpHeaders({"X-Auth-Token": this.authService.getToken().toString()});
    var chooseFileInput = <HTMLInputElement>document.getElementById("chooseFileInput");
    const formData = new FormData();
    formData.append("file", chooseFileInput.files[0]);
    return this.http.post<Document>(this.URL + "/upload", formData, {headers: headers});
  }
}
