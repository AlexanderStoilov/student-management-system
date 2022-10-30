import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { GetAllCoursesService } from './get-all-courses.service';

describe('GetAllCoursesService', () => {
    let service: GetAllCoursesService;

    beforeEach(() => {
        TestBed.configureTestingModule({ imports: [HttpClientTestingModule, RouterModule, RouterTestingModule], });
        service = TestBed.inject(GetAllCoursesService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
