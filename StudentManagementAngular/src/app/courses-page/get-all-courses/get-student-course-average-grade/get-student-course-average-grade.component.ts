import { GetStudentCourseAverageGradeService } from './get-student-course-average-grade.service';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-get-student-course-average-grade',
    templateUrl: './get-student-course-average-grade.component.html',
    styleUrls: ['./get-student-course-average-grade.component.css']
})
export class GetStudentCourseAverageGradeComponent implements OnInit {

    public grade: number;
    @Input() public studentId: string;
    @Input() public courseId: string;

    constructor(private service: GetStudentCourseAverageGradeService) { }

    ngOnInit(): void {
        this.getStudentCourseAverageGrade();
    }

    public isNumber(val): boolean {
        return typeof val === 'number';
    }

    public getStudentCourseAverageGrade() {
        this.service.getStudentCourseAverageGrade(this.studentId, this.courseId)
            .subscribe(
                (data: number) => {
                    this.grade = data;
                    console.log('data = ' + data);
                },
                err => {
                    console.log('getStudentCourseAverageGrade() err: ' + err);
                },
            );


    }

}
