package entities.implementations;

import entities.base.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(name = "total_hours")
    private double totalHours;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Grade> grades;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {
        this.students = null;
    }

    public Course(String name, Double totalHours) {
        super(name);
        this.totalHours = totalHours;
//        this.grades = null;
        this.teacher = null;
        this.students = null;
    }

    public void addStudentToCourse(Student student) {
        this.students.add(student);
    }

    public boolean studentExistsInCourse(Student student) {
        return this.students.contains(student);
    }

    public double getTotalHours() {
        return totalHours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "\"" + getName() + "\" (" + totalHours + " hrs.)";
    }
}