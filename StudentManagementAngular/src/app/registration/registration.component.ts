import { AuthService } from './../auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    username: string;
    password: string;
    type: string;
    degree: string;
    age: number;
    message: any;
    private _selection: any = '-';


    constructor(private service: AuthService, private router: Router) { }

    public get selection() {
        return this._selection;
    }

    public set selection(msg) {
        this._selection = msg;
    }

    public selectStudent() {
        this.selection = "STUDENT";
    }

    public selectTeacher() {
        this.selection = "TEACHER";
    }

    public selectAdmin() {
        this.selection = "ADMIN";
    }

    ngOnInit(): void {
    }

    goToLogin() {
        this.router.navigate(["/login"]);
    }
    register() {
        let response = this.service.register(this.username, this.password, this.type);
        response.subscribe(data => {
            // console.log(data);
            this.message = data;
            this.router.navigate(["/home"]);
        })
    }
}