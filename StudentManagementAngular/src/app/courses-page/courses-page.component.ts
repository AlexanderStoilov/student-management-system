import { AppComponent } from '../app.component';
import { CoursesPageService as CoursesPageService } from './courses-page.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-courses',
    templateUrl: './courses-page.component.html',
    styleUrls: ['./courses-page.component.css']
})
export class CoursesPageComponent implements OnInit {

    public courses: any;
    public filteredCourses: any;
    public commandEnabled: string;

    constructor(private service: CoursesPageService, private router: Router) { }

    ngOnInit(): void {
    }


    public getCoursesMenu() {
        this.commandEnabled = 'getCoursesMenu';
    }

    public addCourseMenu() {
        this.commandEnabled = 'addCourseMenu';
    }

    public addStudentToCourseMenu() {
        this.commandEnabled = 'addStudentToCourseMenu';
    }

    public addGradeToStudentMenu() {
        this.commandEnabled = 'addGradeToStudentMenu';
    }

    public addTeacherToCourseMenu() {
        this.commandEnabled = 'addTeacherToCourseMenu';
    }

    public removeTeacherFromCourseMenu() {
        this.commandEnabled = 'removeTeacherFromCourseMenu';
    }

    goToHome() {
        this.router.navigate(["/home"]);
    }

    public studentGradesStr(student, course) {
        return this.service.studentGradesStr(student.id, course.id);
    }

    public roleIs(role: string): boolean {
        return sessionStorage.getItem('logged_user_role') == 'ROLE_' + role;
    }

    public studentGrades(student, course) {
        let res = this.service.studentGrades(student.id, course.id);
        res.subscribe(
            grades => { student.grades = grades; },
            error => console.log("ERROR STUDENT GRADES"),
            // complete => console.log("course:" + course.id + ", student:" + student.id),
        );
        return res;
    }

    public averageGradeForCourse(course, student) {
        let res = this.service.averageGradeForCourse(course.id, student.id);
        res.subscribe(
            grade => { student.avgGradeStudentCourse = grade },
            () => console.log(student.id),
        )
    }

}
