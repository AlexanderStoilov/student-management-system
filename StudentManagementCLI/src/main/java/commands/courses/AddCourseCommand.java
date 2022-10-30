package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddCourseCommand implements Command {

    private final StudentManagementSystem studentManagementSystem;

    public AddCourseCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addCourse();
    }
}
