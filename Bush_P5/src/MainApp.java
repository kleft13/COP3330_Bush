import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.mainMenu();
    }

    public void mainMenu() {
        displayMainMenu();
        run();
    }

    private void displayMainMenu() {
        System.out.println();
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println();
    }

    private void run(){
        String in = getMenuChoice();
        if(in.contains("1") || in.contains("task list"))
        {
            TaskApp taskApp = new TaskApp();
            taskApp.run();
        }else if(in.contains("2") || in.contains("contact list"))
        {
            ContactApp contactApp = new ContactApp();
            contactApp.run();
        }else if(in.contains("3") || in.contains("quit"))
        {
            System.exit(0);
        }else{
            System.out.println("Invalid menu option.");
        }
    }

    private String getMenuChoice() {
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
