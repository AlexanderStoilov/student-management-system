import { AddCourseService } from './add-course.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-add-course',
    templateUrl: './add-course.component.html',
    styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

    public courseName: string;
    public courseTotalHours: number;

    constructor(private service: AddCourseService) { }

    ngOnInit(): void {
    }

    public addCourse() {
        this.service.addCourse(this.courseName, this.courseTotalHours);
    }

}
