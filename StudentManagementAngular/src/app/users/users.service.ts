import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class UsersService {

    constructor(private http: HttpClient) { }

    public getUsers() {
        // for: UserRestController, line 21 - @PreAuthorize("hasAnyRole('ROLE_ADMIN')") - requires admin credentials
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let usersInfo = this.http.get("http://localhost:8080/users/all", { headers });
        // console.log(usersInfo);
        // usersInfo.forEach(user => console.log(user));
        return usersInfo;
    }
}
