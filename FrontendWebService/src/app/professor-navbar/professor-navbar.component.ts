import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from '../models/Professor';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { ProfessorServiceService } from '../services/professor-service.service';

@Component({
  selector: 'app-professor-navbar',
  templateUrl: './professor-navbar.component.html',
  styleUrls: ['./professor-navbar.component.css']
})
export class ProfessorNavbarComponent implements OnInit {

  professor: Professor;

  constructor(private authService: AuthenticationServiceService, private professorService: ProfessorServiceService, private router: Router) { }

  onLogOut(){
    this.authService.logout(); 
    window.location.reload();
  }


  ngOnInit(): void {
    this.professorService.getloggedTeacher().subscribe((professor)=>{
      this.professor=professor
      setTimeout(() => {
        if (this.professor.active) {
          this.logout();
        }
    }, 1);});
    
  }


  logout(): void{
    this.authService.logout();
    this.router.navigate(['login']);
  }

}
