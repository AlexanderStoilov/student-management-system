import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class RemoveTeacherFromCourseService {

    constructor(private http: HttpClient) { }

    public removeTeacherFromCourse(teacherId: string, courseId: string) {
        let username = "admin2";
        let password = "pass";
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
        let removedTeacherFromCourse = this.http.post("http://localhost:8080/api/v1/courses/" + courseId + "/remove_teacher/" + teacherId, { headers });
        removedTeacherFromCourse.subscribe(x => console.log(x));
        return removedTeacherFromCourse;
    }
}
