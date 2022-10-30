import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetStudentCourseGradesService } from './get-student-course-grades.service';

describe('GetStudentCourseGradesService', () => {
  let service: GetStudentCourseGradesService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(GetStudentCourseGradesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
