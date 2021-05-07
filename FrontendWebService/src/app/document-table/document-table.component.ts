import { Component, OnInit } from '@angular/core';
import { Document } from "../models/Document";

@Component({
  selector: 'app-document-table',
  templateUrl: './document-table.component.html',
  styleUrls: ['./document-table.component.css']
})
export class DocumentTableComponent implements OnInit {
  documents:Document[];

  constructor() { }

  ngOnInit(): void {
    this.documents = [
      {
        id: 1,
        title: "Diplomaaaaaaaaaaaaaaaaaaa"
      },
      {
        id: 2,
        title: "Fotografija"
      },
      {
        id: 3,
        title: "Osigranje"
      }
    ]
  }

}
