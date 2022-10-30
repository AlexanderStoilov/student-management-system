package system.menus.help;

public class HelpMenu {

    public static void print() {
        System.out.println(
            "☞ sm -1 => add a new course.\n" +
            "☞ sm -2 => add a new student.\n" +
            "☞ sm -3 => add a new teacher.\n" +
            "☞ sm -4 => add a teacher to a specific course (max 1).\n" +
            "☞ sm -5 => add a student to a specific course.\n" +
            "☞ sm -6 => add a grade for a student in a specific course. (grade 2.0-6.0)\n" +
            "☞ sm -7 => show all students grouped by course (alphabetically) and then by their average grade for the course (ascending).\n" +
            "☞ sm -8 => show all courses and their teachers and students (without grades).\n" +
            "☞ sm -9 => show the average grade for all students in a specific course.\n" +
            "☞ sm -10 => show a total average grade for a student (between all of his courses using the average grade).\n"
        );
    }
}
