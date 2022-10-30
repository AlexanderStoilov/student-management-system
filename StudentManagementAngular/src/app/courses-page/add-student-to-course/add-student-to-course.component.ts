import { AddStudentToCourseService } from './add-student-to-course.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-add-student-to-course',
    templateUrl: './add-student-to-course.component.html',
    styleUrls: ['./add-student-to-course.component.css']
})
export class AddStudentToCourseComponent implements OnInit {

    public studentId: string;
    public courseId: string;

    constructor(private service: AddStudentToCourseService) { }

    ngOnInit(): void {
    }

    public addStudentToCourse() {
        this.service.addStudentToCourse(this.studentId, this.courseId);
    }

}
