import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators'
import { JwtUtilsService } from './jwt-utils.service';
import { throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  private readonly loginPath = 'http://localhost:8080/api/login';

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService) { }

  login(username: string, password: string): Observable<boolean> {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    var loginInfo = {
      username: username,
      password: password
    };

    return this.http.post(this.loginPath, JSON.stringify(loginInfo), { headers: headers, responseType: "text" }).pipe(map((res: any) => {
      //let token = res && res['token'];
      let token = res;
      if (token) {
        localStorage.setItem('currentUser', JSON.stringify({
          username: username,
          roles: this.jwtUtilsService.getRoles(token),
          token: token
        }));
        return true;
      }
      else {
        return false;
      }
    }),catchError((error: any) => {
      if (error.status === 400) {
        throwError("Illegal login");
      }
      else {
        return Observable.throw(error.json().error || 'Server error');
      }
    }
    ))
  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    if (this.getToken() != '') return true;
    else return false;
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return undefined;
    }
  }
  
}
