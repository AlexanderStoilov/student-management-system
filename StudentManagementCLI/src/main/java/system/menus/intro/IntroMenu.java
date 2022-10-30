package system.menus.intro;

public class IntroMenu {
    public static void show() {
        System.out.println(
            "Welcome to the Student Management App! We are glad you are hopping on board with us.\n" +
            "If you already know the commands, feel free to use them. If you don't, type \"sm --help\" for instructions. \n" +
            "If you want to stop the process, type \"quit()\", or just hit ENTER twice..."
        );
    }
}
