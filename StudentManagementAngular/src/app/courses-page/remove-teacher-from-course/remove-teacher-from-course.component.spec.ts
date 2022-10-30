import { RemoveTeacherFromCourseService } from './remove-teacher-from-course.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveTeacherFromCourseComponent } from './remove-teacher-from-course.component';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('RemoveTeacherFromCourseComponent', () => {
    let component: RemoveTeacherFromCourseComponent;
    let fixture: ComponentFixture<RemoveTeacherFromCourseComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [RemoveTeacherFromCourseComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(RemoveTeacherFromCourseComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should remove the teacher from a course', () => {
        let teacherToRemoveId: string = "99472d59-0403-4b86-b5a8-a95ea1457fc8"; //Rogger Roggers, BSC, assigned as a teacher to 'Indian'
        let courseToRemoveFromId: string = "d6d0db96-90ce-42f4-99f9-2481659d5cf5"; //Indian, 130
        expect(component.teacherId).toBeFalsy();
        expect(component.courseId).toBeFalsy();
        let service = TestBed.inject(RemoveTeacherFromCourseService);
        expect(service).toBeTruthy();
        spyOn(service, "removeTeacherFromCourse").and.callFake(() => {
            return of([teacherToRemoveId, courseToRemoveFromId]);
        })
        component.teacherId = teacherToRemoveId;
        component.courseId = courseToRemoveFromId;
        component.removeTeacherFromCourse()
        expect(component.teacherId).toBe(teacherToRemoveId);
        expect(component.courseId).toBe(courseToRemoveFromId);
    });

});
