package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class ShowAverageGradeAllStudentsInCourseCommand implements Command {

    private final StudentManagementSystem studentManagementSystem;

    public ShowAverageGradeAllStudentsInCourseCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.showAverageGradeAllStudentsInCourse();
    }

}
