import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AddStudentToCourseService } from './add-student-to-course.service';

describe('AddStudentToCourseService', () => {
  let service: AddStudentToCourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(AddStudentToCourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
