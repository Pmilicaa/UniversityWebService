import { Component, OnInit } from '@angular/core';
import Document  from "../models/Document";
import { DocumentServiceService } from '../services/document-service.service';

@Component({
  selector: 'app-document-table',
  templateUrl: './document-table.component.html',
  styleUrls: ['./document-table.component.css']
})
export class DocumentTableComponent implements OnInit {
  documents:Document[];

  constructor(private documentService: DocumentServiceService) { }

  onUpload(): void {
    console.log("called first");
    this.documentService.uploadDocument().subscribe();
  }

  ngOnInit(): void {
    this.documentService.getAll().subscribe( (documents) => (this.documents = documents))
  }

}
