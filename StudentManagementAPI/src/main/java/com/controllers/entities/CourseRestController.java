package com.controllers.entities;


import entities.implementations.Course;
import entities.implementations.Student;
import entities.implementations.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.implementations.CourseService;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/courses")
@PreAuthorize("hasAuthority('ROLE_TEACHER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STUDENT')")
public class CourseRestController {

    private final CourseService courseService = new CourseService();

    @PostMapping(path = "/add_course")
    public ResponseEntity<Course> addCourse(@RequestBody Course newCourse) {
        Course addedCourse = this.courseService.addCourse(newCourse);
        return ResponseEntity.ok(addedCourse);
    }

    @PostMapping(path = "/{courseId}/add_teacher/{teacherId}")
    @PreAuthorize("hasAuthority('course:add_teacher')")
    public ResponseEntity<Teacher> addTeacherToCourse(@PathVariable String courseId, @PathVariable String teacherId) {
        Teacher addedTeacher = this.courseService.addTeacherToCourse(courseId, teacherId);
        return ResponseEntity.ok(addedTeacher);
    }

    @PostMapping(path = "/{courseId}/remove_teacher/{teacherId}")
    public ResponseEntity<Teacher> removeTeacherFromCourse(@PathVariable String courseId, @PathVariable String teacherId){
        Teacher removedTeacher = this.courseService.removeTeacherFromCourse(courseId, teacherId);
        return ResponseEntity.ok(removedTeacher);
    }

    @PostMapping(path = "/{courseId}/add_student/{studentId}")
    @PreAuthorize("hasAuthority('course:add_student')")
    public ResponseEntity<Student> addStudentToCourse(@PathVariable String courseId, @PathVariable String studentId) {
        Student addedStudent = this.courseService.addStudentToCourse(courseId, studentId);
        return ResponseEntity.ok(addedStudent);
    }

    @GetMapping(path = "/{courseId}/students")
    public ResponseEntity<String> getAllStudentsInCourse(@PathVariable String courseId) {
        String allStudents = this.courseService.getAllStudentsInCourse(courseId);
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping(path = "/{courseId}/students/ord")
    public ResponseEntity<String> getAllStudentsInCourseAndGradeByNameDescending(@PathVariable String courseId) {
        String allStudentsInCourseGradeAndSortedName = this.courseService.getAllStudentsInCourseAndGradeByNameDescending(courseId);
        return ResponseEntity.ok(allStudentsInCourseGradeAndSortedName);
    }

    @GetMapping(path = "/{courseId}/avg_grades")
    @PreAuthorize("hasAuthority('course:see_average_grade')")
    public ResponseEntity<String> getAverageGradesOfAllStudents(@PathVariable String courseId) {
        String avgGradesAllStudents = this.courseService.getAverageGradesOfAllStudents(courseId);
        return ResponseEntity.ok(avgGradesAllStudents);
    }

    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('course:see_all_info')")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> allCourses = this.courseService.getAll();
        return ResponseEntity.ok(allCourses);
    }

    @GetMapping(path = "/{courseId}")
    public ResponseEntity<Course> get(@PathVariable String courseId) {
        Optional<Course> course = this.courseService.get(courseId);
        return course.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping(path = "/{courseId}/teacher")
    ResponseEntity<Teacher> getTeacher(@PathVariable String courseId) {
        Teacher teacher = this.courseService.getTeacher(courseId);
        if (isNull(teacher)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(teacher);
        }
    }

    @GetMapping(path = "/{courseId}/uuid")
    public ResponseEntity<String> getCourseUUID(@PathVariable String courseId) {
        if (isNull(courseId)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(courseId);
        }
    }
}
