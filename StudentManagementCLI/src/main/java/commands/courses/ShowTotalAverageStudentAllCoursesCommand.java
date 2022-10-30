package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class ShowTotalAverageStudentAllCoursesCommand implements Command {

    private final StudentManagementSystem studentManagementSystem;

    public ShowTotalAverageStudentAllCoursesCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.showTotalAverageStudentAllCourses();
    }

}
