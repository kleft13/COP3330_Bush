import java.util.*;

public class App {

    public static void main(String[] args)
    {
        runMainMenu();
    }

    public static void displayMenu()
    {
        System.out.println("Main Menu");
        System.out.println("----------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.print("> ");
    }

    public static void check()
    {
        Scanner m = new Scanner(System.in);
        String main = m.nextLine();
        switch (main) {
            case "1" -> {
                System.out.println("new task list has been created\n");
                TaskList lister = new TaskList();
                runListMenu(lister);
            }
            case "2" ->{
                System.out.print("Which file would you like to open?: ");
                Scanner again = new Scanner(System.in);
                String res = again.nextLine();
                String fle = res + ".txt";
                TaskList lister = new TaskList();
                lister.loadList(fle);
                runListMenu(lister);
            }
            case "3" -> System.exit(0);
            default -> {
                System.out.println("Warning: Improper Input, Try Again");
                check();
            }
        }

    }

    public static void displayListMenu()
    {
        System.out.println("List Operation Menu");
        System.out.println("--------------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.print("> ");
    }

    public static void runMainMenu()
    {
        displayMenu();
        check();
    }

    public static void runListMenu(TaskList lister)
    {
        displayListMenu();
        checkLM(lister);
    }

    public static void checkLM(TaskList lister)
    {
        Scanner l = new Scanner(System.in);
        String lm = l.nextLine();
        switch (lm) {
            case "1" -> {
                lister.listList();
                runListMenu(lister);
            }
            case "2" -> TaskItem.prompt(lister);
            case "3" -> {
                lister.editItems(lister);
                runListMenu(lister);
            }
            case "4" -> {
                lister.deleteItem();
                runListMenu(lister);
            }
            case "5" -> {
                lister.markComp();
                runListMenu(lister);
            }
            case "6" -> {
                lister.unmarkComp();
                runListMenu(lister);
            }
            case "7" -> lister.saveList();
            case "8" -> runMainMenu();
            default -> {
                System.out.println("Warning: Improper Input, Try Again");
                checkLM(lister);
            }
        }
    }
}