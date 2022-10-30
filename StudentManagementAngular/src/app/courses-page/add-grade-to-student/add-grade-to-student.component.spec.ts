import { AddGradeToStudentService } from './add-grade-to-student.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGradeToStudentComponent } from './add-grade-to-student.component';
import { of } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('AddGradeToStudentComponent', () => {
    let component: AddGradeToStudentComponent;
    let fixture: ComponentFixture<AddGradeToStudentComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [AddGradeToStudentComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(AddGradeToStudentComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });



    it('should add a grade to a student', () => {
        let gradeToBeAdded: number = 3.6; // new grade to be added to John Wanders in 'Indian' (130)
        let studentToAddId: string = "0d941e32-b825-4a70-a5aa-8cafc5af66df"; //John Wanders, 25, assigned to 'Indian'
        let courseToAddToId: string = "9e31181a-46f8-43f8-8d8b-be914ca22855"; //Indian, 130.0
        expect(component.grade).toBeFalsy();
        expect(component.studentId).toBeFalsy();
        expect(component.courseId).toBeFalsy();
        let service = TestBed.inject(AddGradeToStudentService);
        expect(service).toBeTruthy();
        spyOn(service, "addGradeToStudent").and.callFake(() => {
            return of([gradeToBeAdded, studentToAddId, courseToAddToId]);
        })
        component.grade = gradeToBeAdded;
        component.studentId = studentToAddId;
        component.courseId = courseToAddToId;
        component.addGradeToStudent()
        expect(component.studentId).toBe(studentToAddId);
        expect(component.courseId).toBe(courseToAddToId);
    });

});
