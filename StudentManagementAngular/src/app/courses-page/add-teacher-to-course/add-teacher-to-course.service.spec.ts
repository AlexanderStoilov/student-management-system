import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AddTeacherToCourseService } from './add-teacher-to-course.service';

describe('AddTeacherToCourseService', () => {
  let service: AddTeacherToCourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(AddTeacherToCourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
