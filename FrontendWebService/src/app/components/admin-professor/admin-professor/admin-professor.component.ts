import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from 'src/app/models/Professor';
import { AdminProfessorsService } from 'src/app/services/admin-professors.service';
import { Location } from '@angular/common';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-admin-professor',
  templateUrl: './admin-professor.component.html',
  styleUrls: ['./admin-professor.component.css']
})
export class AdminProfessorComponent implements OnInit {

  professors: Professor[];

  constructor(private adminProfessorsService: AdminProfessorsService,private route: Router,private location: Location) { }

  title = "Professors"
  public profesor:Professor=new Professor();
  public selectedProfesor:Professor=new Professor();
  ngOnInit(): void {
    this.adminProfessorsService.getAll().subscribe((professors) => (this.professors = professors));
    

  }
 
  addTeacher(){
    console.log(this.profesor);
    this.adminProfessorsService.addTeacher(this.profesor).subscribe((result) => {
      if(result){
        this.profesor=new Professor();



      }
    });
  }
  editTeacher(){
    console.log(this.selectedProfesor);
    this.adminProfessorsService.editTeacher(this.selectedProfesor).subscribe((result) => {
      if(result){
        this.selectedProfesor=new Professor();



      }
    });
  }
  goBack(): void {
    this.location.back();
  }
  public showAddTeacher(): void {
    let x = document.getElementById("addTeacher");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }
  public showEditTeacher(profesor:Professor): void {
    this.selectedProfesor=JSON.parse(JSON.stringify(profesor));;
    this.selectedProfesor.user.password="";
    let x = document.getElementById("editTeacher");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }
  removeTeacher(profesor:Professor){
    console.log(profesor);
    this.adminProfessorsService.deleteTeacher(profesor).subscribe((result) => {
     
    
    } ,(error)=>{
    console.log(error);
    });

  }
  reloadCurrentPage() {
    window.location.reload();
   }
}
