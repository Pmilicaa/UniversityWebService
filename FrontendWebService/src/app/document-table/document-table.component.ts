import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import Document  from "../models/Document";
import FileResponse from '../models/FileResponse';
import { DocumentServiceService } from '../services/document-service.service';

@Component({
  selector: 'app-document-table',
  templateUrl: './document-table.component.html',
  styleUrls: ['./document-table.component.css']
})
export class DocumentTableComponent implements OnInit {
  documents:Document[] = [];

  constructor(private documentService: DocumentServiceService) { }

  onUpload(): void {
<<<<<<< HEAD
    this.documentService.uploadDocument().subscribe( (document) => { 
      this.documents.push(document);
    });
=======
    console.log("called first");
    this.documentService.uploadDocument().subscribe();
>>>>>>> 3f8fe5d1f46b9766c89d40e6ec5dcc27b52a1ae4
  }

  ngOnInit(): void {
    this.documentService.getAll().subscribe( (documents) => (this.documents = documents))
  }

}
