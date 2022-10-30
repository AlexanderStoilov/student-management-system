import { UsersComponent } from './users.component';
import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { UsersService } from './users.service';
import { HttpTestingController, HttpClientTestingModule, TestRequest } from '@angular/common/http/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

describe('UsersService', () => {
    let service: UsersService;
    let httpTestingController: HttpTestingController;
    let component: UsersComponent;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],

        });
        service = TestBed.inject(UsersService);
        httpTestingController = TestBed.inject(HttpTestingController);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });

})
