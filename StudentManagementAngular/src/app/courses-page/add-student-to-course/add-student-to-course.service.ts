import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AddStudentToCourseService {

    constructor(private http: HttpClient) { }

    public addStudentToCourse(studentId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let addedStudentToCourse = this.http.post("http://localhost:8080/api/v1/courses/" + courseId + "/add_student/" + studentId, { headers });
        addedStudentToCourse.subscribe(x => console.log(x));
        return addedStudentToCourse;
    }

}
