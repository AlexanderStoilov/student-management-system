import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AddGradeToStudentService } from './add-grade-to-student.service';

describe('AddGradeToStudentService', () => {
  let service: AddGradeToStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],});
    service = TestBed.inject(AddGradeToStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
