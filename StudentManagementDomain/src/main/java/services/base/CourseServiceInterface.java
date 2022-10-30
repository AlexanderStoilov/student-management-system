package services.base;

import entities.implementations.Course;
import entities.implementations.Student;
import entities.implementations.Teacher;

import java.util.List;

public interface CourseServiceInterface {
    Course addCourse(Course course);

    Student addStudentToCourse(String courseId, String studentId);

    Teacher addTeacherToCourse(String courseId, String teacherId);

    String getAllStudentsInCourse(String courseId);

    public List<Course> getAll();

    String getAverageGradesOfAllStudents(String courseId);

    public String getCourseUUID(int seqId);
}
