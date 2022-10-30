import controller.Controller;
import system.StudentManagementSystem;
import system.menus.intro.IntroMenu;
import еxecutors.Executor;


public class CLI {
    public static void main(String[] args) {
        Controller controller = new Controller();
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        IntroMenu.show();
        Executor.executeInstruction(studentManagementSystem, controller);
    }
}
