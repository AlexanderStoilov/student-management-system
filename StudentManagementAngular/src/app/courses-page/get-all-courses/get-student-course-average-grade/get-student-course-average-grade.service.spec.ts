import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetStudentCourseAverageGradeService } from './get-student-course-average-grade.service';

describe('GetStudentCourseAverageGradeService', () => {
  let service: GetStudentCourseAverageGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(GetStudentCourseAverageGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
