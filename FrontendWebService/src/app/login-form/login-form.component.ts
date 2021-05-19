import { Component, Input, OnInit } from '@angular/core';
import { AuthenticationServiceService } from '../services/authentication-service.service';
import { NgForm } from "@angular/forms";
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';
import {Router} from "@angular/router";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Input() onLogin: () => void;

  constructor(private authenticationService: AuthenticationServiceService,
    private router: Router) { }

  login(form: NgForm): void{
    console.log(form.value);
    var username: string = form.value.username;
    var password: string = form.value.password;
    
    this.authenticationService.login(username, password).subscribe(
      (loggedIn:boolean) => {
        if(loggedIn){
          this.router.navigate([""]);
        }
      }
    ,
    (err:Error) => {
      if(err.toString()==='Ilegal login'){
        
        console.log(err);
      }
      else{
        console.log(err);
        throwError(err);
      }
    });
  }

  ngOnInit(): void {
  }

}