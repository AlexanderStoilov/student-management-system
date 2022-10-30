package entities.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.base.BaseEntity;
import entities.enums.TeacherDegree;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    @Enumerated
    @Column(name = "degree")
    private TeacherDegree degree;

    @OneToOne
    @JsonIgnore
    private Course course;

    public Teacher() {
        this.course = null;
        this.degree = null;
    }

    public Teacher(String name, String degree) {
        super(name);
        this.degree = TeacherDegree.valueOf(degree.toUpperCase());
    }

    public TeacherDegree getDegree() {
        return degree;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Mr./Mrs. " + getName() + " (" + degree.toString() + ")";
    }
}