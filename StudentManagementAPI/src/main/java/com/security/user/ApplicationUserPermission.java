package com.security.user;

public enum ApplicationUserPermission {

    SEE_STUDENT_AVG_GRADE("student:see_average_grade"),
    SEE_COURSE_AVG_GRADE("course:see_average_grade"),
    SEE_ALL_COURSES_INFO("course:see_all_info"),
    ADD_GRADE_TO_STUDENT("student:add_grade"),
    ADD_STUDENT_TO_COURSE("course:add_student"),
    ADD_TEACHER_TO_COURSE("course:add_teacher"),
    CHANGE_USER_ROLE("user:change_role");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
