import { AuthService } from '../auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home-page.component.html',
    styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

    constructor(private router: Router, private authService: AuthService) { }

    ngOnInit(): void {
    }

    logout() {
        this.authService.logout();
    }

    goToUsers() {
        this.router.navigate(["/users"]);
    }

    goToCourses() {
        this.router.navigate(["/courses"]);
    }

    goToAdmin() {
        this.router.navigate(["/admin"]);
    }

    public roleIs(role: string): boolean {
        return sessionStorage.getItem('logged_user_role') == 'ROLE_' + role;
    }

}
