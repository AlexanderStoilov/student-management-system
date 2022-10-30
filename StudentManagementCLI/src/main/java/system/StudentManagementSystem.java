package system;

import entities.implementations.Course;
import entities.implementations.Student;
import entities.implementations.Teacher;
import services.implementations.CourseService;
import services.implementations.StudentService;
import services.implementations.TeacherService;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class StudentManagementSystem {

    private final CourseService courseService = new CourseService();
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();

    //sm -1
    public void addCourse() {
        System.out.println("Adding a course:");
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter total hours: ");
        double totalHours = new Scanner(System.in).nextDouble();
        Course addedCourse = this.courseService.createCourse(name, totalHours);
        System.out.println("Course " + addedCourse + " added.");
    }

    //sm -2
    public void addStudent() {
        System.out.println("Adding a student:");
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter age: ");
        int age = new Scanner(System.in).nextInt();
        Student addedStudent = this.studentService.createStudent(name, age);
        System.out.println("Student " + addedStudent + " added.");
    }

    //sm -3
    public void addTeacher() {
        System.out.println("Adding a teacher:");
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter degree: ");
        String degree = new Scanner(System.in).nextLine();
        Teacher addedTeacher = this.teacherService.createTeacher(name, degree);
        System.out.println("Teacher " + addedTeacher + " added.");
    }

    //sm -4
    public void addTeacherToCourse() {
        System.out.println("Adding a teacher to a course.");
        System.out.println("See all available teachers: ");
        System.out.println(this.teacherService.getAll());

        System.out.println("See all available courses: ");
        System.out.println(this.courseService.getAll());

        System.out.println("Enter teacher seq. id: ");
        int seqTeacherId = new Scanner(System.in).nextInt();
        System.out.println("Enter course seq. id: ");
        int seqCourseId = new Scanner(System.in).nextInt();

        String teacherId = this.teacherService.getTeacherUUID(seqTeacherId);
        String courseId = this.courseService.getCourseUUID(seqCourseId);
//        System.out.println("seqTeacherId = " + seqTeacherId);
//        System.out.println("teacherId = " + teacherId);
//        System.out.println("seqCourseId = " + seqCourseId);
//        System.out.println("courseId = " + courseId);
        this.courseService.addTeacherToCourse(courseId, teacherId);
        System.out.println("Teacher with id=" + teacherId + " added to course with id=" + courseId);
    }

    //sm -5
    public void addStudentToCourse() {
        System.out.println("Adding a student to a course.");
        System.out.println("Available students: ");
        System.out.println(this.studentService.getAll());

        System.out.println("Available courses: ");
        System.out.println(this.courseService.getAll());

        System.out.println("Enter student id: ");
        int seqStudentId = new Scanner(System.in).nextInt();
        System.out.println("Enter course id: ");
        int seqCourseId = new Scanner(System.in).nextInt();

        String studentId = String.valueOf(this.studentService.getStudentUUID(seqStudentId));
        String courseId = String.valueOf(this.courseService.getCourseUUID(seqCourseId));
        this.courseService.addStudentToCourse(courseId, studentId);
        System.out.println("Student with id=" + studentId + " added to course with id=" + courseId);
    }

    //sm -6
    public void addGradeForStudentInCourse() {
        System.out.println("Adding a grade for a student in course");
        System.out.println("Available students: ");
        System.out.println(this.studentService.getAll());

        System.out.println("Available courses: ");
        System.out.println(this.courseService.getAll());

        System.out.println("Input student id: ");
        int seqStudentId = new Scanner(System.in).nextInt();
        System.out.println("Input course id: ");
        int seqCourseId = new Scanner(System.in).nextInt();
        System.out.println("Input grade to be added: ");
        double newGrade = new Scanner(System.in).nextDouble();

        String studentId = String.valueOf(this.studentService.getStudentUUID(seqStudentId));
        String courseId = String.valueOf(this.courseService.getCourseUUID(seqCourseId));

        this.studentService.addGrade(studentId, courseId, newGrade);
        System.out.println("Grade " + newGrade + " added to student with id=" + studentId + " in course with id=" + courseId);
    }

    //sm -7
    public void showAllStudentsGroupedByCourseAndAverageScoreAscending() {
        System.out.println("Showing all students grouped by course and average score in the course ascending.\n");
        for (Course course : this.courseService.getAll()) {
            System.out.println("\t->  " + course);
            if (isNull(course) || isNull(course.getStudents())) {
                continue;
            }
            for (Student student : course.getStudents()) {
                System.out.println(student + " with grade " + student.averageGradeForCourse(course));
            }
            System.out.println("==========================================================\n");
        }
    }

    //sm -8
    public void showAllCoursesAndTeachersAndStudents() {
        System.out.println("Showing all courses and their corresponding teachers and students.\n");
        for (Course course : this.courseService.getAll()) {
            System.out.println(course + "\n------------------------");
            System.out.println("\t=> Students: " + this.courseService.getAllStudentsInCourse(course.getId()));
            System.out.println("\t=> Teachers: " + this.courseService.getTeacher(course.getId()) + "\n");
        }
    }

    //sm -9
    public void showAverageGradeAllStudentsInCourse() {
        System.out.println("Showing the average grade for all students in a given course.");
        System.out.println("Available courses: ");
        System.out.println(this.courseService.getAll());

        System.out.println("Input course id: ");
        int seqCourseId = new Scanner(System.in).nextInt();
        String courseId = this.courseService.getCourseUUID(seqCourseId);

        Course course = this.courseService.get(courseId).orElse(null);
        assert course != null;
        System.out.println(this.courseService.getAverageGradesOfAllStudents(courseId));
    }

    //sm -10
    public void showTotalAverageStudentAllCourses() {
        System.out.println("Showing total average grade for a student throughout all of their courses");
        System.out.println("Available students: ");
        System.out.println(this.studentService.getAll());

        System.out.println("Input student id: ");
        int seqStudentId = new Scanner(System.in).nextInt();

        String studentId = String.valueOf(this.studentService.getStudentUUID(seqStudentId));
        Student student = this.studentService.get(studentId).orElse(null);

        assert student != null;
        System.out.println(student.averageGradeTotal());
    }

}
