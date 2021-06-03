import { Component, OnInit } from '@angular/core';
import Transaction from "../../models/Transaction";
import { FinanceService } from '../../services/finance.service';

@Component({
  selector: 'app-finance-history',
  templateUrl: './finance-history.component.html',
  styleUrls: ['./finance-history.component.css']
})
export class FinanceHistoryComponent implements OnInit {
  transactions:Transaction[] = [];

  constructor(private financeService: FinanceService) { }

  ngOnInit(): void {
    this.financeService.getAll().subscribe( (transactions) => (this.transactions = transactions))
  }

}
