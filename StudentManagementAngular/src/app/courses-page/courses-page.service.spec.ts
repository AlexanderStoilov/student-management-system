import { CoursesPageComponent } from './courses-page.component';
import { TestBed } from '@angular/core/testing';

import { CoursesPageService } from './courses-page.service';
import { HttpClientTestingModule, HttpTestingController, TestRequest } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('CoursesPageService', () => {
    let service: CoursesPageService;
    let httpTestingController: HttpTestingController;
    let component: CoursesPageComponent;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],

        });
        service = TestBed.inject(CoursesPageService);
        httpTestingController = TestBed.inject(HttpTestingController);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });


    // describe("#getCourses", () => {
    //     service.getCourses();
    //     let coursesInSystemData = component.courses;
    //     it("should get the courses stored in the system", (done: DoneFn) => {
    //         service.getCourses().subscribe(
    //             data => {
    //                 expect(data).toBe(coursesInSystemData);
    //             }
    //         )
    //         const testRequest: TestRequest = httpTestingController.expectOne(`localhost:8080/api/v1/courses/all`)
    //         expect(testRequest.request.method).toEqual("GET");
    //     })
    // })

});
