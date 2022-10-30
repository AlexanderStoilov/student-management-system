import { AddTeacherToCourseComponent } from './courses-page/add-teacher-to-course/add-teacher-to-course.component';
import { RouterModule } from '@angular/router';
import { HttpInterceptorService } from './auth/httpInterceptor.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UsersComponent } from './users/users.component';
import { CoursesPageComponent } from './courses-page/courses-page.component';
import { AdminComponent } from './admin/admin.component';
import { RegistrationComponent } from './registration/registration.component';
import { GetAllCoursesComponent } from './courses-page/get-all-courses/get-all-courses.component';
import { GradeLetterConverterPipe } from './pipes/grade-letter-converter-pipe/grade-letter-converter.pipe';
import { AverageGradePrefixerPipe } from './pipes/average-grade-prefix-pipe/average-grade-prefixer.pipe';
import { UserPresentationPageComponent } from './user-presentation-page/user-presentation-page.component';
import { AddCourseComponent } from './courses-page/add-course/add-course.component';
import { AddStudentToCourseComponent } from './courses-page/add-student-to-course/add-student-to-course.component';
import { AddGradeToStudentComponent } from './courses-page/add-grade-to-student/add-grade-to-student.component';
import { RemoveTeacherFromCourseComponent } from './courses-page/remove-teacher-from-course/remove-teacher-from-course.component';
import { GetStudentCourseGradesComponent } from './courses-page/get-all-courses/get-student-course-grades/get-student-course-grades.component';
import { GetStudentCourseAverageGradeComponent } from './courses-page/get-all-courses/get-student-course-average-grade/get-student-course-average-grade.component';


@NgModule({
    declarations: [
        AppComponent,
        LoginComponent,
        RegistrationComponent,
        HomePageComponent,
        UsersComponent,
        CoursesPageComponent,
        AdminComponent,
        GetAllCoursesComponent,
        GradeLetterConverterPipe,
        AverageGradePrefixerPipe,
        UserPresentationPageComponent,
        AddCourseComponent,
        AddStudentToCourseComponent,
        AddTeacherToCourseComponent,
        AddGradeToStudentComponent,
        RemoveTeacherFromCourseComponent,
        GetStudentCourseGradesComponent,
        GetStudentCourseAverageGradeComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot([]),
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: HttpInterceptorService,
            multi: true,
        },
        HttpClientModule,
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
