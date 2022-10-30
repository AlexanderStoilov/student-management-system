import { AddStudentToCourseService } from './add-student-to-course.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudentToCourseComponent } from './add-student-to-course.component';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('AddStudentToCourseComponent', () => {
    let component: AddStudentToCourseComponent;
    let fixture: ComponentFixture<AddStudentToCourseComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [AddStudentToCourseComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(AddStudentToCourseComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should add the student to the course', () => {

        let studentToAddId: string = "a33cb500-5c40-4cd5-8e1e-3cf4b6b83b17"; //Student 142, 38
        let courseToAddToId: string = "b4ffbff3-c4dc-4b95-87bd-66af00d7406c"; //English, 250.0
        expect(component.studentId).toBeFalsy();
        expect(component.courseId).toBeFalsy();
        let service = TestBed.inject(AddStudentToCourseService);
        expect(service).toBeTruthy();
        spyOn(service, "addStudentToCourse").and.callFake(() => {
            return of([studentToAddId, courseToAddToId]);
        })
        component.studentId = studentToAddId;
        component.courseId = courseToAddToId;
        component.addStudentToCourse()
        expect(component.studentId).toBe(studentToAddId);
        expect(component.courseId).toBe(courseToAddToId);
    });

});
