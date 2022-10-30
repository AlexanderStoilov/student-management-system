import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AddGradeToStudentService {

    constructor(private http: HttpClient) { }

    public addGradeToStudent(grade: number, studentId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let addedGrade = this.http.post("http://localhost:8080/api/v1/students/" + studentId + '/' + courseId + "/add_grade/" + grade, { headers });
        addedGrade.subscribe(x => console.log(x));
        return addedGrade;
    }
}
