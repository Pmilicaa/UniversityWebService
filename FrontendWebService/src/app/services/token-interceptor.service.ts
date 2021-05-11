import { HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService {

  constructor(private inj: Injector) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authenticationService:AuthenticationServiceService = this.inj.get(AuthenticationServiceService);
    request = request.clone({
      setHeaders: {
        'Authorization': `JWT ${authenticationService.getToken()}`
      }
    });

    return next.handle(request);
  }
}
