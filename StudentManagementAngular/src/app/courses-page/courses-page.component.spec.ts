import { GradeLetterConverterPipe } from './../pipes/grade-letter-converter-pipe/grade-letter-converter.pipe';
import { AppComponent } from './../app.component';
import { AppModule } from './../app.module';
import { of } from 'rxjs';
import { CoursesPageService } from './courses-page.service';
import { RouterTestingModule } from '@angular/router/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CoursesPageComponent } from './courses-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';


describe('CoursesPageComponent', () => {
    let component: CoursesPageComponent;
    let fixture: ComponentFixture<CoursesPageComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [
                CoursesPageComponent,
            ],
            imports: [
                HttpClientTestingModule,
                ReactiveFormsModule,
                RouterTestingModule,
                RouterModule,
            ],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();

        fixture = TestBed.createComponent(CoursesPageComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

});
