import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AddCourseService {

    constructor(private http: HttpClient) { }

    public addCourse(courseName: string, courseTotalHours: number) {
        let username = "admin2";
        let password = "pass";
        let body = {
            "name": courseName,
            "totalHours": courseTotalHours,
        };
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let res = this.http.post("http://localhost:8080/api/v1/courses/add_course/", body, { headers });
        res.subscribe(x => console.log(x));
        return res;
    }
}
