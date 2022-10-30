package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddStudentToCourseCommand implements Command {
    private final StudentManagementSystem studentManagementSystem;

    public AddStudentToCourseCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addStudentToCourse();
    }
}
