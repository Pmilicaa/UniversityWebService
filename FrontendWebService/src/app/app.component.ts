import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontendWebService';
  roles: string[]= [];
  currentUser: any;

  constructor(private router: Router) { 

  }

  ngOnInit(){
    this.roles = this.getCurrentUser().roles;
    this.currentUser = this.getCurrentUser();
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return false;
    }
  }

}
