package entities.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.base.BaseId;
import jakarta.persistence.*;


@Entity
@Table(name = "grades")
public class Grade extends BaseId{

    @ManyToOne(targetEntity = Student.class)
    @JsonIgnore
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(targetEntity = Course.class)
    @JsonIgnore
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "grade")
    private Double value;

    public Grade(){
        super();
        this.student = null;
        this.course = null;
        this.value = 0.0;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}