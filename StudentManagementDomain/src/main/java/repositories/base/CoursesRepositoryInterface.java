package repositories.base;

import entities.implementations.Course;
import entities.implementations.Teacher;

public interface CoursesRepositoryInterface extends BaseRepositoryInterface<Course> {
    Teacher getTeacher(String id);
}
