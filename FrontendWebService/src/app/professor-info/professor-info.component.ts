import { Component, OnInit } from '@angular/core';
import {Professor} from '../models/Professor';

@Component({
  selector: 'app-professor-info',
  templateUrl: './professor-info.component.html',
  styleUrls: ['./professor-info.component.css']
})
export class ProfessorInfoComponent implements OnInit {

  constructor() { }
  professor:Professor={
    firstName:'Milica',
    lastName:'Pajic',
    userName:'pmilica'
  }
  ngOnInit(): void {
  }

}
