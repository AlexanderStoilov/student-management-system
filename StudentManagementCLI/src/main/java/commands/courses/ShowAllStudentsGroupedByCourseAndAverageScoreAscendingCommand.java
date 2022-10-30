package commands.courses;

import commands.interfaces.Command;
import system.StudentManagementSystem;

public class ShowAllStudentsGroupedByCourseAndAverageScoreAscendingCommand implements Command {
    private final StudentManagementSystem studentManagementSystem;

    public ShowAllStudentsGroupedByCourseAndAverageScoreAscendingCommand(StudentManagementSystem sms) {
        this.studentManagementSystem = sms;
    }

    @Override
    public void execute() {
        studentManagementSystem.showAllStudentsGroupedByCourseAndAverageScoreAscending();
    }
}
