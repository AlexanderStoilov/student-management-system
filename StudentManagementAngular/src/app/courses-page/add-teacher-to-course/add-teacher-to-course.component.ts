import { AddTeacherToCourseService } from './add-teacher-to-course.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-add-teacher-to-course',
    templateUrl: './add-teacher-to-course.component.html',
    styleUrls: ['./add-teacher-to-course.component.css']
})
export class AddTeacherToCourseComponent implements OnInit {

    public teacherId: string;
    public courseId: string;

    constructor(private service: AddTeacherToCourseService) { }

    ngOnInit(): void {
    }

    public addTeacherToCourse() {
        this.service.addTeacherToCourse(this.teacherId, this.courseId);
    }

}
