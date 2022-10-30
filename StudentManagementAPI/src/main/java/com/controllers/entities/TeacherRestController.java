package com.controllers.entities;

import entities.implementations.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.implementations.TeacherService;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/teachers")
@PreAuthorize("hasAuthority('ROLE_TEACHER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_STUDENT')")
public class TeacherRestController {
    private final TeacherService teacherService = new TeacherService();

    @PostMapping(path = "/add_teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher addedTeacher = this.teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(addedTeacher);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> allTeachers = this.teacherService.getAll();
        return ResponseEntity.ok(allTeachers);
    }

    @GetMapping(path = "/{teacherId}")
    public ResponseEntity<Teacher> get(@PathVariable String teacherId) {
        Optional<Teacher> teacher = this.teacherService.get(teacherId);
        return teacher.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping(path = "/{teacherId}/uuid")
    public ResponseEntity<String> getTeacherUUID(@PathVariable String teacherId) {
        if (isNull(teacherId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(teacherId);
        }

    }
}
