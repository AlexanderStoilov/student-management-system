import { UsersService } from './users.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

    private _users: any;
    constructor(private service: UsersService, private router: Router) { }

    ngOnInit(): void {
    }

    public getUsers() {
        let response = this.service.getUsers();
        response.subscribe(data => this._users = data);
    }

    goToHome() {
        this.router.navigate(["/home"]);
    }

    public get users(){
        return this._users;
    }


}
