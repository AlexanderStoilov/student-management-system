import { AddGradeToStudentService } from './add-grade-to-student.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-add-grade-to-student',
    templateUrl: './add-grade-to-student.component.html',
    styleUrls: ['./add-grade-to-student.component.css']
})
export class AddGradeToStudentComponent implements OnInit {

    public studentId: string;
    public courseId: string;
    public grade: number;

    constructor(private service: AddGradeToStudentService) { }

    ngOnInit(): void {
    }

    public addGradeToStudent() {
        this.service.addGradeToStudent(this.grade, this.studentId, this.courseId);
    }
}
