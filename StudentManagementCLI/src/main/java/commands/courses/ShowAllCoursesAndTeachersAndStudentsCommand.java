package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class ShowAllCoursesAndTeachersAndStudentsCommand implements Command {
    private final StudentManagementSystem studentManagementSystem;

    public ShowAllCoursesAndTeachersAndStudentsCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.showAllCoursesAndTeachersAndStudents();
    }
}
