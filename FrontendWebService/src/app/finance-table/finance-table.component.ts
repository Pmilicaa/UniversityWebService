import { Component, OnInit } from '@angular/core';
import Transaction from "../models/Transaction";
import { FinanceService } from '../services/finance.service';

@Component({
  selector: 'app-finance-table',
  templateUrl: './finance-table.component.html',
  styleUrls: ['./finance-table.component.css']
})
export class FinanceTableComponent implements OnInit {
  transactions:Transaction[];

  constructor(private financeService: FinanceService) { }

  ngOnInit(): void {
    this.financeService.getAll().subscribe( (transactions) => (this.transactions = transactions))
  }

}
