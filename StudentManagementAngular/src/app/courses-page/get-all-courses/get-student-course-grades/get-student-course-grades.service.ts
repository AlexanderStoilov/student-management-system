import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class GetStudentCourseGradesService {

    constructor(private http: HttpClient) { }

    public getStudentCourseGrades(studentId: string, courseId: string) {
        const headers = new HttpHeaders({
            Authorization: sessionStorage.getItem("logged_user_auth"),
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
        });
        let studentGradesForCourse = this.http.get<any[]>("http://localhost:8080/api/v1/students/" + studentId + "/grades_in_course/" + courseId,
            { headers, /*withCredentials: true*/ });
        // console.log('studenGradesForCourse => ' + studentGradesForCourse );
        return studentGradesForCourse;
    }
}
