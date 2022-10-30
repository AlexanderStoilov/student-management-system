import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetStudentCourseGradesComponent } from './get-student-course-grades.component';

describe('GetStudentCourseGradesComponent', () => {
  let component: GetStudentCourseGradesComponent;
  let fixture: ComponentFixture<GetStudentCourseGradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
        imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
      declarations: [ GetStudentCourseGradesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetStudentCourseGradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
