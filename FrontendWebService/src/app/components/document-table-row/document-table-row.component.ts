import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: '[app-document-table-row]',
  templateUrl: './document-table-row.component.html',
  styleUrls: ['./document-table-row.component.css']
})
export class DocumentTableRowComponent implements OnInit {

  @Input() index;
  @Input() document;

  constructor() { }

  ngOnInit(): void {
  }

}
