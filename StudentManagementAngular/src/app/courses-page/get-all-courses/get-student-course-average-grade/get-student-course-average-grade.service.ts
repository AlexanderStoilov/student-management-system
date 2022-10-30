import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class GetStudentCourseAverageGradeService {

    constructor(private http: HttpClient) { }

    public getStudentCourseAverageGrade(studentId: string, courseId: string) {
        const headers = new HttpHeaders({
            Authorization: sessionStorage.getItem("logged_user_auth"),
        });
        let studentGradesForCourse = this.http.get<any>("http://localhost:8080/api/v1/students/" + studentId + "/avg_grade_course/" + courseId,
            { headers });
        // console.log('studenGradesForCourse => ' + studentGradesForCourse );
        return studentGradesForCourse;
    }
}
