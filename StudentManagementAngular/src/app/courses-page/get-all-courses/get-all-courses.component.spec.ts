import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetAllCoursesComponent } from './get-all-courses.component';

describe('GetAllCoursesComponent', () => {
    let component: GetAllCoursesComponent;
    let fixture: ComponentFixture<GetAllCoursesComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
            declarations: [GetAllCoursesComponent]
        })
            .compileComponents();

        fixture = TestBed.createComponent(GetAllCoursesComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
