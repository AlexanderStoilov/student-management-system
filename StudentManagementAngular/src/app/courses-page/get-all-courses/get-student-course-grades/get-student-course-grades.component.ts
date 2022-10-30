import { GetStudentCourseGradesService } from './get-student-course-grades.service';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-get-student-course-grades',
    templateUrl: './get-student-course-grades.component.html',
    styleUrls: ['./get-student-course-grades.component.css']
})
export class GetStudentCourseGradesComponent implements OnInit {

    public grades: any[];
    @Input() public studentId: string;
    @Input() public courseId: string;

    constructor(private service: GetStudentCourseGradesService) { }

    ngOnInit(): void {
        this.studentGrades();
    }

    public studentGrades() {
        this.service.getStudentCourseGrades(this.studentId, this.courseId)
            .subscribe(
                async data => {
                    this.grades = data as any[];
                    // console.log(data)
                    console.log('In getStudentCourseGrades() BODY');
                },
                err => { console.log('In getStudentCourseGrades() ERR' + err) },
                () => { },
            );
    }

}
