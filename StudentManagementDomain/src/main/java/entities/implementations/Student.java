package entities.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.base.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    @ManyToMany
    @JsonIgnore
    private List<Course> courses;

    public Student() {
        this.grades = null;
        this.courses = null;
    }

    public Student(String name, int age) {
        super(name);
        this.age = age;
        this.grades = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addGradeToStudent(Grade grade) {
        this.grades.add(grade);
    }

    public void addCourseToStudent(Course course) {
        this.courses.add(course);
    }

    public double averageGradeTotal() {
        return this.grades.stream().mapToDouble(Grade::getValue).average().orElse(0.0);
    }

    public double averageGradeForCourse(Course course) {
        return this.grades.stream().filter(grade -> grade.getCourse().getId().equals(course.getId())).mapToDouble(Grade::getValue).average().orElse(0.0);
    }

    public List<Double> gradesForCourse(Course course) {
        double[] arr = this.grades.stream().filter(grade -> grade.getCourse().getId().equals(course.getId())).mapToDouble(Grade::getValue).toArray();
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return getName() + " (" + age + " y/o)";
    }

}