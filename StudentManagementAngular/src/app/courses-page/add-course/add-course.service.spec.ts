import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AddCourseService } from './add-course.service';

describe('AddCourseService', () => {
    let service: AddCourseService;

    beforeEach(() => {
        TestBed.configureTestingModule({ imports: [HttpClientTestingModule, RouterModule, RouterTestingModule], });

        service = TestBed.inject(AddCourseService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
