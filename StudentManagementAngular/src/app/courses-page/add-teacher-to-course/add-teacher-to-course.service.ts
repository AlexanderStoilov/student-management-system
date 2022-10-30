import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AddTeacherToCourseService {

    constructor(private http: HttpClient) { }

    public addTeacherToCourse(teacherId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let addedTeacherToCourse = this.http.post("http://localhost:8080/api/v1/courses/" + courseId + "/add_teacher/" + teacherId, { headers });
        addedTeacherToCourse.subscribe(x => console.log(x));
        return addedTeacherToCourse;
    }
}
