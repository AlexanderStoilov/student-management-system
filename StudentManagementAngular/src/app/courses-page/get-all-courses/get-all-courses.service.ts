import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GetAllCoursesService {

  constructor(private http: HttpClient) { }

  public getCourses() {
    let username = "admin2";
    let password = "pass";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) });
    let coursesInfo = this.http.get("http://localhost:8080/api/v1/courses/all", { headers });
    // coursesInfo.forEach(course => console.log(course));
    return coursesInfo;
}
}
