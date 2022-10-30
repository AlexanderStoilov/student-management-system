import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class CoursesPageService {

    private _gradesStr: any;

    constructor(private http: HttpClient) { }

    public get gradesStr() {
        return this._gradesStr;
    }

    public set gradesStr(x) {
        this._gradesStr = x;
    }

    public averageGradeForCourse(courseId, studentId) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let avgGrade = this.http.get("http://localhost:8080/api/v1/students/" + studentId + "/avg_grade_course/" + courseId, { headers });
        return avgGrade;
    }

    public studentGrades(studentId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let studentGradesForCourse = this.http.get("http://localhost:8080/api/v1/students/" + studentId + "/grades_in_course/" + courseId,
            { headers });
        return studentGradesForCourse;
    }

    public studentGradesStr(studentId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let studentGradesForCourse = this.http.get("http://localhost:8080/api/v1/students/" + studentId + "/grades_in_course_str/" + courseId, { headers });
        // console.log('Student grades for course: ' + studentGradesForCourse);
        return studentGradesForCourse;
        // return "studentGrades<-";
    }

}
