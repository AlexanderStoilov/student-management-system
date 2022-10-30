import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    readonly USER_NAME_SESSION_ATTRIBUTE = 'logged_user_auth';
    readonly LOGGED_USER_DATA_ATTRIBUTE = 'logged_user_role';

    constructor(private http: HttpClient, private router: Router) { }

    login(username: string, password: string) {
        return this.http.get(`http://localhost:8080/login`,
            { headers: { authorization: this.createBasicAuthToken(username, password) }, responseType: 'text' as 'json' })
            .pipe(map((userRole) => {
                this.registerSuccessfulLogin(username, password, userRole);
            }));
    }

    register(username: string, password: string, type: string) {
        const body = {
            "username": username,
            "password": password,
            "type": type,
        };
        return this.http.post(`http://localhost:8080/registration`, body);
    }

    private createBasicAuthToken(username: String, password: String) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }

    registerSuccessfulLogin(username: string, password: string, currentUser: any) {
        let basicAuthToken = this.createBasicAuthToken(username, password);

        sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE, basicAuthToken)
        sessionStorage.setItem(this.LOGGED_USER_DATA_ATTRIBUTE, currentUser)
    }

    logout() {
        sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE);
        sessionStorage.removeItem(this.LOGGED_USER_DATA_ATTRIBUTE);
        this.router.navigate(["/login"]);
    }

    getLoggedInUser() {
        return sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    }

    getLoggedInUserData() {
        return sessionStorage.getItem(this.LOGGED_USER_DATA_ATTRIBUTE);
    }

}
