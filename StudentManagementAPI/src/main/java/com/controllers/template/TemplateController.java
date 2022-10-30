package com.controllers.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    // No HTML used in the submodule
    /*

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("registration")
    public String getRegistrationView() {
        return "registration";
    }

    @GetMapping("courses")
    public String getCourses() {
        return "courses";
    }

    @GetMapping("students")
    public String getStudents() {
        return "students";
    }

    @GetMapping("teachers")
    public String getTeachers() {
        return "teachers";
    }
     */

}
