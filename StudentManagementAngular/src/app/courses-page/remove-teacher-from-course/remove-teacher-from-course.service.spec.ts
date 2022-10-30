import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { RemoveTeacherFromCourseService } from './remove-teacher-from-course.service';

describe('RemoveTeacherFromCourseService', () => {
  let service: RemoveTeacherFromCourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(RemoveTeacherFromCourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
