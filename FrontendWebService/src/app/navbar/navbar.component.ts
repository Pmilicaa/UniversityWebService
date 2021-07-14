import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../models/Student';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { StudentServiceService } from '../services/student-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  student: Student;

  constructor(private authService: AuthenticationServiceService, private studentService: StudentServiceService, private router: Router) { }

  onLogout(): void {
    this.authService.logout();
    window.location.reload();
  }

  ngOnInit(): void {
    this.studentService.getMe().subscribe((student)=>{
      this.student=student
      setTimeout(() => {
        if (this.student.active == false) {
          this.logout();
        }
    }, 1);});
  }

  logout(): void{
    this.authService.logout();
    this.router.navigate(['login']);
  }

}
