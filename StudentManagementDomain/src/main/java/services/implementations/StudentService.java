package services.implementations;

import entities.implementations.Course;
import entities.implementations.Grade;
import entities.implementations.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repositories.implementations.CourseRepository;
import repositories.implementations.GradeRepository;
import repositories.implementations.StudentRepository;
import services.base.StudentServiceInterface;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentsRepository;
    private CourseRepository coursesRepository;
    private GradeRepository gradeRepository;

    public StudentService() {
        this.studentsRepository = new StudentRepository();
        this.coursesRepository = new CourseRepository();
        this.gradeRepository = new GradeRepository();
    }

    public StudentService(StudentRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student createStudent(String name, int age) {
        Student student = new Student(name, age);
        return this.addStudent(student);
    }

    @Override
    public Student addStudent(Student student) {
        this.studentsRepository.save(student);
        return student;
    }

    public Optional<Student> deleteStudent(String studentId) {
        Optional<Student> studentToRemoveOption = this.studentsRepository.get(studentId);
        if (studentToRemoveOption.isPresent()){
            Student studentToRemove = studentToRemoveOption.get();
            this.studentsRepository.remove(studentToRemove);
        }
        return studentToRemoveOption;
    }

    @Override
    public Double addGrade(String studentId, String courseId, Double grade) {
        Student student = this.studentsRepository.validate(studentId);
        Course course = this.coursesRepository.validate(courseId);

        Grade newGrade = new Grade();
        newGrade.setValue(grade);
        newGrade.setCourse(course);
        newGrade.setStudent(student);
        student.addGradeToStudent(newGrade);
        this.gradeRepository.save(newGrade);
//
//        if (!this.studentsRepository.exists(studentId)) {
//            this.studentsRepository.save(student);
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentManagementJPA");
//            EntityManager em = emf.createEntityManager();
//            em.getTransaction().begin();
////            em.merge(newGrade);
//            em.getTransaction().commit();
//        }
//
//        if (student.getCourses().stream().noneMatch(c -> c.getId().equals(courseId))) {
//            Objects.requireNonNull(this.coursesRepository.get(courseId).orElse(null)).addStudentToCourse(student);
//        }
        return grade;
    }

    @Override
    public Double getAverageGrade(String studentId) {
        Student student = this.studentsRepository.validate(studentId);
        return student.averageGradeTotal();
    }

    public Double getAverageGradeForCourse(String studentId, String courseId) {
        Student student = this.studentsRepository.validate(studentId);
        Course course = this.coursesRepository.validate(courseId);
        return student.averageGradeForCourse(course);
    }

    public List<Double> getGradesForCourse(String studentId, String courseId){
        Course course = this.coursesRepository.validate(courseId);
        Student student = this.studentsRepository.validate(studentId);
        return student.gradesForCourse(course);

    }

    public List<Student> getAll() {
        return this.studentsRepository.getAll();
    }

    public Optional<Student> get(String id) {
        return this.studentsRepository.get(id);
    }

    public String getStudentUUID(int seqId) {
        Optional<String> res = this.studentsRepository.getUUID(seqId);
        return res.orElse(null);
    }

    public int getCortegesNr() {
        return this.studentsRepository.getCortegesNr();
    }

}
