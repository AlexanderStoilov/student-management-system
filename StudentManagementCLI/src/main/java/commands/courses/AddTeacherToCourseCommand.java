package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddTeacherToCourseCommand implements Command {
    private final StudentManagementSystem studentManagementSystem;

    public AddTeacherToCourseCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addTeacherToCourse();
    }
}
