import { Component, OnInit } from '@angular/core';
import { Transaction } from "../models/Transaction";

@Component({
  selector: 'app-finance-table',
  templateUrl: './finance-table.component.html',
  styleUrls: ['./finance-table.component.css']
})
export class FinanceTableComponent implements OnInit {
  transactions:Transaction[] = [
    {
      id: 1,
      type:"Deposit",
      amount: 1500,
      date: "2.5.2020"
    },
    {
      id: 2,
      type:"Deposit",
      amount: 5000,
      date: "20.12.2020"
    },
    {
      id: 3,
      type:"Deposit",
      amount: 12500,
      date: "1.2.2021"
    },
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
