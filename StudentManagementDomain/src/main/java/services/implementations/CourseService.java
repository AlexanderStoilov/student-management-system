package services.implementations;

import entities.implementations.Course;
import entities.implementations.Student;
import entities.implementations.Teacher;
import repositories.implementations.CourseRepository;
import repositories.implementations.StudentRepository;
import repositories.implementations.TeacherRepository;
import services.base.CourseServiceInterface;

import java.util.*;

import static java.util.Objects.isNull;

public class CourseService implements CourseServiceInterface {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;


    public CourseService() {
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
    }

    public CourseService(CourseRepository courseRepository) {
        this();
        this.courseRepository = courseRepository;
    }

    public Course createCourse(String name, double totalHours) {
        Course course = new Course(name, totalHours);
        return this.addCourse(course);
    }

    @Override
    public Course addCourse(Course course) {
        this.courseRepository.save(course);
        return course;

    }

    @Override
    public Student addStudentToCourse(String courseId, String studentId) {
        Course course = this.courseRepository.validate(courseId);
        Student student = this.studentRepository.validate(studentId);

        //throws
        //        if (course.studentExistsInCourse(student)) {
        //            return null;
        //        }

        course.addStudentToCourse(student);
        student.addCourseToStudent(course);
        this.courseRepository.save(course);
        this.studentRepository.save(student);
        return student;

    }

    @Override
    public Teacher addTeacherToCourse(String courseId, String teacherId) {
        Course course = this.courseRepository.validate(courseId);
        Teacher teacher = this.teacherRepository.validate(teacherId);

        course.setTeacher(teacher);
        teacher.setCourse(course);
        this.courseRepository.save(course);
        this.teacherRepository.save(teacher);
        return teacher;
    }

    public Teacher removeTeacherFromCourse(String courseId, String teacherId) {
        Course course = this.courseRepository.validate(courseId);
        Teacher teacher = this.teacherRepository.validate(teacherId);

        course.setTeacher(null);
        teacher.setCourse(null);
        // We probably should remove them from the persistance entity forever.
        //        this.courseRepository.remove(course);
        //        this.teacherRepository.remove(teacher);
        return teacher;
    }

    @Override
    public String getAllStudentsInCourse(String courseId) {
        StringBuilder res = new StringBuilder();
        Course course = this.courseRepository.validate(courseId);
        if (isNull(course) || isNull(course.getStudents())) {
            return "No students in course";
        }
        for (Student student : course.getStudents()) {
            res.append(student)
                    .append(", ");
        }
        return res.toString();
    }

    public String getAllStudentsInCourseAndGradeByNameDescending(String courseId) {
        StringBuilder res = new StringBuilder();
        Course course = this.courseRepository.validate(courseId);
        List<Student> students = course.getStudents();

        res
                .append(course.getName())
                .append(System.lineSeparator());

        students
                .stream()
                .sorted(Comparator
                        .comparing(Student::getName))
                .forEach(student -> res.append(String.format("\t%s: %.2f%n",
                        student.getName(),
                        student.averageGradeForCourse(course))));

        return res.toString();
    }

    @Override
    public String getAverageGradesOfAllStudents(String courseId) {
        StringBuilder res = new StringBuilder();
        Course course = this.courseRepository.validate(courseId);
        res.append("\t -> ").append(course.getName())
                .append(System.lineSeparator());
        course
                .getStudents()
                .forEach(student -> res.append(student)
                        .append(" with grade ")
                        .append(student.averageGradeForCourse(course))
                        .append(System.lineSeparator()));
        return res.toString();
    }

    @Override
    public List<Course> getAll() {
        return this.courseRepository.getAll();
    }

    public Optional<Course> get(String id) {
        return this.courseRepository.get(id);
    }

    public Teacher getTeacher(String id) {
        return this.courseRepository.getTeacher(id);
    }

    public String getCourseUUID(int seqId) {
        Optional<String> res = this.courseRepository.getUUID(seqId);
        return res.orElse(null);
    }

    public int getCortegesNr() {
        return this.courseRepository.getCortegesNr();
    }
}
