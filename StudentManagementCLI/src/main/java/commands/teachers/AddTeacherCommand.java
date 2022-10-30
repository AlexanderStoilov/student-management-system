package commands.teachers;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddTeacherCommand implements Command {

    private final StudentManagementSystem studentManagementSystem;

    public AddTeacherCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addTeacher();
    }
}
