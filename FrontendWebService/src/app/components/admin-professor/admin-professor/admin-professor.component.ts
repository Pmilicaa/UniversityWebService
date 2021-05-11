import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/models/Professor';
import { AdminProfessorsService } from 'src/app/services/admin-professors.service';

@Component({
  selector: 'app-admin-professor',
  templateUrl: './admin-professor.component.html',
  styleUrls: ['./admin-professor.component.css']
})
export class AdminProfessorComponent implements OnInit {

  professors: Professor[];

  constructor(private adminProfessorsService: AdminProfessorsService) { }

  title = "Professors"

  ngOnInit(): void {
    this.adminProfessorsService.getAll().subscribe((professors) => (this.professors = professors))
  }

}
