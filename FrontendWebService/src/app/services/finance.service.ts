import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import Transaction from "../models/Transaction";

@Injectable({
  providedIn: 'root'
})
export class FinanceService {
  
  private readonly URL = "http://localhost:8080/transactions"

  constructor(private http: HttpClient) { }

  getAll(): Observable<Transaction[]>{
      return this.http.get<Transaction[]>(this.URL);
  }
}
