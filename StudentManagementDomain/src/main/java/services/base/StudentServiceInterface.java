package services.base;

import entities.implementations.Student;

public interface StudentServiceInterface {
    Student addStudent(Student student);

    Double addGrade(String studentId, String courseId, Double grade);

    Double getAverageGrade(String studentId);

    public String getStudentUUID(int seqId);
}
