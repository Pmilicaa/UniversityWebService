import { Component, OnInit } from '@angular/core';
import Document from '../models/Document';

@Component({
  selector: 'app-list-group',
  templateUrl: './list-group.component.html',
  styleUrls: ['./list-group.component.css']
})
export class ListGroupComponent implements OnInit {
  documents:Document[];

  constructor() { }

  ngOnInit(): void {
  }

}
