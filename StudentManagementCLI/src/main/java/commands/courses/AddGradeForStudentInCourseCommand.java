package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddGradeForStudentInCourseCommand implements Command {
    private final StudentManagementSystem studentManagementSystem;

    public AddGradeForStudentInCourseCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addGradeForStudentInCourse();
    }
}
