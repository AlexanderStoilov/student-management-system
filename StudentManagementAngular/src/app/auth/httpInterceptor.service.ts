import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

    constructor(private authService: AuthService,
        private injector: Injector) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authService = this.injector.get(AuthService)

        if (this.authService.getLoggedInUser() !== null && req.url.indexOf('basicauth') === -1) {
            const authReq = req.clone({
                headers: new HttpHeaders({
                    'Content-Type': 'application/json',
                    'Authorization': `${authService.getLoggedInUser()}`
                })
            });
            return next.handle(authReq);
        } else {
            return next.handle(req);
        }
    }
}