import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AddCourseComponent } from './add-course.component';

describe('AddCourseComponent', () => {
    let component: AddCourseComponent;
    let fixture: ComponentFixture<AddCourseComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [AddCourseComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(AddCourseComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
