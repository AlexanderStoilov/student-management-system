package commands.students;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class AddStudentCommand implements Command {

    private final StudentManagementSystem studentManagementSystem;

    public AddStudentCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.addStudent();
    }
}
