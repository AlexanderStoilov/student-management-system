package com.controllers.entities;

import com.google.common.primitives.Doubles;
import entities.implementations.Student;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;
import services.implementations.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/students")
//@PreAuthorize("hasAuthority('ROLE_TEACHER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STUDENT')")
public class StudentRestController {
    private final StudentService studentService = new StudentService();

    @PostMapping(path = "/add_student")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
        Student addedStudent = this.studentService.addStudent(newStudent);
        return ResponseEntity.ok(addedStudent);
    }

    @PostMapping(path = "/{studentId}/{courseId}/add_grade/{grade}")
    @PreAuthorize("hasAuthority('student:add_grade')")
    public ResponseEntity<Double> addGrade(@PathVariable String studentId, @PathVariable String courseId, @PathVariable double grade) {
        double addedGrade = this.studentService.addGrade(studentId, courseId, grade);
        return ResponseEntity.status(HttpStatus.OK).body(addedGrade);
    }

    @GetMapping(path = "/{studentId}/avg_grade")
    @PreAuthorize("hasAuthority('student:see_average_grade')")
    public ResponseEntity<Double> getAverageGrade(@PathVariable String studentId) {
        double studentGrade = this.studentService.getAverageGrade(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(studentGrade);
    }

    @GetMapping(path = "/{studentId}/avg_grade_course/{courseId}")
    @PreAuthorize("hasAuthority('student:see_average_grade')")
    public ResponseEntity<Double> getAverageGradeForCourse(@PathVariable String studentId, @PathVariable String courseId) {
        double studentGrade = this.studentService.getAverageGradeForCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK).body(studentGrade);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = this.studentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> get(@PathVariable String studentId) {
        Optional<Student> student = this.studentService.get(studentId);
        return student.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping(path = "/{studentSeqId}/uuid")
    public ResponseEntity<String> getStudentUUID(@PathVariable String studentId) {
        if (isNull(studentId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(studentId);
        }
    }

    @GetMapping(path = "/{studentId}/grades_in_course/{courseId}")
    public ResponseEntity<List<Double>> getGradesForCourse(@PathVariable String studentId, @PathVariable String courseId) {
        List<Double> studentGradesForCourse = this.studentService.getGradesForCourse(studentId, courseId);
        return ResponseEntity.ok(studentGradesForCourse);
    }

    @GetMapping(path = "/{studentId}/grades_in_course_str/{courseId}")
    public ResponseEntity<String> getGradesForCourseAsString(@PathVariable String studentId, @PathVariable String courseId) {
        List<Double> studentGradesForCourse = this.studentService.getGradesForCourse(studentId, courseId);
        String res = Doubles.join(", ", studentGradesForCourse.stream().mapToDouble(Double::doubleValue).toArray());
        return ResponseEntity.ok(res);
    }

}
