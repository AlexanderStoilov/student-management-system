import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetStudentCourseAverageGradeComponent } from './get-student-course-average-grade.component';

describe('GetStudentCourseAverageGradeComponent', () => {
  let component: GetStudentCourseAverageGradeComponent;
  let fixture: ComponentFixture<GetStudentCourseAverageGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
        imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],
      declarations: [ GetStudentCourseAverageGradeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetStudentCourseAverageGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
