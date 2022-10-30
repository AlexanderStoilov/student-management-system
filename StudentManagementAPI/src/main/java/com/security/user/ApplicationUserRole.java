package com.security.user;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.security.user.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(SEE_STUDENT_AVG_GRADE, SEE_COURSE_AVG_GRADE, SEE_ALL_COURSES_INFO)),
    TEACHER(Sets.newHashSet(SEE_STUDENT_AVG_GRADE, SEE_COURSE_AVG_GRADE, SEE_ALL_COURSES_INFO, ADD_GRADE_TO_STUDENT, ADD_STUDENT_TO_COURSE)),
    ADMIN(Sets.newHashSet(SEE_STUDENT_AVG_GRADE, SEE_COURSE_AVG_GRADE, SEE_ALL_COURSES_INFO, ADD_GRADE_TO_STUDENT, ADD_STUDENT_TO_COURSE, ADD_TEACHER_TO_COURSE, CHANGE_USER_ROLE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    public String get() {
        return "ROLE_" + this.name();
    }

}
