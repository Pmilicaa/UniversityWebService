import { Component, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../services/authentication-service.service';

@Component({
  selector: 'app-professor-navbar',
  templateUrl: './professor-navbar.component.html',
  styleUrls: ['./professor-navbar.component.css']
})
export class ProfessorNavbarComponent implements OnInit {

  constructor(private authService: AuthenticationServiceService) { }

  onLogOut(){
    this.authService.logout(); 
    window.location.reload();
  }
  ngOnInit(): void {
  }

}
