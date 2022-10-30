package еxecutors;

import commands.courses.*;
import commands.interfaces.Command;
import commands.students.AddStudentCommand;
import commands.teachers.AddTeacherCommand;
import controller.Controller;
import system.StudentManagementSystem;
import system.menus.help.HelpMenu;

import java.util.Scanner;

public class Executor {
    public static void executeInstruction(StudentManagementSystem studentManagementSystem, Controller controller) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (!(input = sc.nextLine()).equals("")) {
            switch (input) {
                case "sm -1":
                    Command addCourse = new AddCourseCommand(studentManagementSystem);
                    controller.setCommand(addCourse);
                    controller.executeCommand();
                    break;

                case "sm -2":
                    Command addStudent = new AddStudentCommand(studentManagementSystem);
                    controller.setCommand(addStudent);
                    controller.executeCommand();
                    break;

                case "sm -3":
                    Command addTeacher = new AddTeacherCommand(studentManagementSystem);
                    controller.setCommand(addTeacher);
                    controller.executeCommand();
                    break;

                case "sm -4":
                    Command addTeacherToCourse = new AddTeacherToCourseCommand(studentManagementSystem);
                    controller.setCommand(addTeacherToCourse);
                    controller.executeCommand();
                    break;

                case "sm -5":
                    Command addStudentToCourse = new AddStudentToCourseCommand(studentManagementSystem);
                    controller.setCommand(addStudentToCourse);
                    controller.executeCommand();
                    break;

                case "sm -6":
                    Command addGradeForStudentInCourse = new AddGradeForStudentInCourseCommand(studentManagementSystem);
                    controller.setCommand(addGradeForStudentInCourse);
                    controller.executeCommand();
                    break;

                case "sm -7":
                    Command showAllStudentsGroupedByCourseAndAverageScoreAscending = new ShowAllStudentsGroupedByCourseAndAverageScoreAscendingCommand(studentManagementSystem);
                    controller.setCommand(showAllStudentsGroupedByCourseAndAverageScoreAscending);
                    controller.executeCommand();
                    break;

                case "sm -8":
                    Command showAllCoursesAndTeachersAndStudents = new ShowAllCoursesAndTeachersAndStudentsCommand(studentManagementSystem);
                    controller.setCommand(showAllCoursesAndTeachersAndStudents);
                    controller.executeCommand();
                    break;


                case "sm -9":
                    Command showAverageGradeAllStudentsInCourse = new ShowAverageGradeAllStudentsInCourseCommand(studentManagementSystem);
                    controller.setCommand(showAverageGradeAllStudentsInCourse);
                    controller.executeCommand();
                    break;


                case "sm -10":
                    Command showTotalAverageStudentAllCourses = new ShowTotalAverageStudentAllCoursesCommand(studentManagementSystem);
                    controller.setCommand(showTotalAverageStudentAllCourses);
                    controller.executeCommand();
                    break;

                case "sm --help":
                    HelpMenu.print();
                    break;

                case "quit()":
                    System.out.println("Exiting... See you soon!");
                    return;

                default:
                    System.out.println("Invalid command. Try again...");
                    break;
            }
        }
    }
}
