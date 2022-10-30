import { AuthService } from '../auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    username: string;
    password: string;
    message: any;

    constructor(private service: AuthService, private router: Router) {
        if (this.service.getLoggedInUser()) {
            this.router.navigate(["/home"]);
        }
    }

    ngOnInit(): void {
    }

    doLogin() {
        let response = this.service.login(this.username, this.password);
        response.subscribe(data => {
            // console.log(data);
            this.message = data;
            this.router.navigate(["/home"]);
        })
    }

    goToRegistration() {
        this.router.navigate(["/registration"]);
    }

}
