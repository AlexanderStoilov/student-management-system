import { AddTeacherToCourseService } from './add-teacher-to-course.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTeacherToCourseComponent } from './add-teacher-to-course.component';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('AddTeacherToCourseComponent', () => {
    let component: AddTeacherToCourseComponent;
    let fixture: ComponentFixture<AddTeacherToCourseComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [AddTeacherToCourseComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(AddTeacherToCourseComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should add a teacher to a course', () => {
        let teacherToAddId: string = "a3a10864-cdd6-4968-b4e4-b7d0b3fd96ee"; //Victoria Wallace, MSC
        let courseToAddToId: string = "d6d0db96-90ce-42f4-99f9-2481659d5cf5"; //English 2, 550.0
        expect(component.teacherId).toBeFalsy();
        expect(component.courseId).toBeFalsy();
        let service = TestBed.inject(AddTeacherToCourseService);
        expect(service).toBeTruthy();
        spyOn(service, "addTeacherToCourse").and.callFake(() => {
            return of([teacherToAddId, courseToAddToId]);
        })
        component.teacherId = teacherToAddId;
        component.courseId = courseToAddToId;
        component.addTeacherToCourse()
        expect(component.teacherId).toBe(teacherToAddId);
        expect(component.courseId).toBe(courseToAddToId);
    });

});
