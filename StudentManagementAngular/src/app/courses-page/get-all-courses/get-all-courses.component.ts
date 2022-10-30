import { GetAllCoursesService } from './get-all-courses.service';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
    selector: 'app-get-all-courses',
    templateUrl: './get-all-courses.component.html',
    styleUrls: ['./get-all-courses.component.css']
})
export class GetAllCoursesComponent implements OnInit {

    @Input() public courses: any;
    public filteredCourses: any;
    public text: any;
    

    constructor(private service: GetAllCoursesService) { }

    ngOnInit(): void {
        this.getCourses();
        this.filteredCourses = this.courses;
    }

    public getCourses() {
        let response = this.service.getCourses();
        response.subscribe(data => this.courses = data);
        this.filteredCourses = this.courses;
    }

    searchNameSelection(text) {
        if (!text) {
            console.log("No filter applied.");
            this.filteredCourses = this.courses;
        }
        else {
            let filter = this.courses.filter(e => {
                return e.name.toLowerCase() === text.toLowerCase() ||
                    e.name.toLowerCase().indexOf(text.toLowerCase()) >= 0;
            });
            // console.log(filter);
            this.filteredCourses = filter;
        }
    }

    clearNameSelection() {
        this.filteredCourses = this.courses;
    }

    public roleIs(role: string): boolean {
        return sessionStorage.getItem('logged_user_role') == 'ROLE_' + role;
    }

}
