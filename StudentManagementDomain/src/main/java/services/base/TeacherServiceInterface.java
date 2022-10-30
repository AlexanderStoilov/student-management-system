package services.base;

import entities.implementations.Teacher;

import java.util.List;

public interface TeacherServiceInterface {
    public Teacher addTeacher(Teacher teacher);

    public List<Teacher> getAll();

    public String getTeacherUUID(int seqId);
}
