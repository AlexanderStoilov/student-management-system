import { RemoveTeacherFromCourseService } from './remove-teacher-from-course.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-remove-teacher-from-course',
    templateUrl: './remove-teacher-from-course.component.html',
    styleUrls: ['./remove-teacher-from-course.component.css']
})
export class RemoveTeacherFromCourseComponent implements OnInit {

    public teacherId: string;
    public courseId: string;

    constructor(private service: RemoveTeacherFromCourseService) { }

    ngOnInit(): void { }

    public removeTeacherFromCourse() {
        this.service.removeTeacherFromCourse(this.teacherId, this.courseId);
    }

}
