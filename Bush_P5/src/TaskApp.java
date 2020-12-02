import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp extends MainApp {
    private static final Scanner input = new Scanner(System.in);
    private TaskList taskList;

    public static void main(String[] args) {
        TaskApp taskApp = new TaskApp();
        taskApp.run();
    }

    public void run() {
        String taskMenuChoice;
        while(true) {
            displayTaskMenu();
            taskMenuChoice = getMenuChoice();

            if (taskMenuChoice.contains("1") || taskMenuChoice.contains("create")) {
                createList();
                modifyList();
            } else if (taskMenuChoice.contains("2") || taskMenuChoice.contains("load")) {
                try {
                    loadList();
                    modifyList();
                } catch(IllegalArgumentException | InputMismatchException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (taskMenuChoice.contains("3") || taskMenuChoice.contains("quit")) {
                mainMenu();
            } else {
                System.out.println("Invalid menu option.");
            }
        }
    }

    private void displayTaskMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println();
    }

    private String getMenuChoice() {
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void createList() {
        taskList = new TaskList();
        System.out.println("new task list has been created");
    }

    private void loadList() {
        System.out.print("Enter the filename to load: ");
        String filename = input.nextLine();

        taskList = new TaskList();
        taskList.load(filename);

        System.out.println("task list has been loaded");
    }

    private void modifyList() {
        String taskMenuChoice;
        while(true) {
            displayOperationMenu();
            taskMenuChoice = getMenuChoice();

            if (taskMenuChoice.contains("1") || taskMenuChoice.contains("view")) {
                displayItems();
            } else if (taskMenuChoice.contains("2") || taskMenuChoice.contains("add")) {
                addItem();
            } else if (taskMenuChoice.contains("3") || taskMenuChoice.contains("edit")) {

                // we could use a try / catch here, but if statements are generally faster
                if (taskList.size() > 0) {
                    editItem();
                } else {
                    System.out.println("no tasks to edit");
                }
            } else if (taskMenuChoice.contains("4") || taskMenuChoice.contains("remove")) {
                if (taskList.size() > 0) {
                    removeItem();
                } else {
                    System.out.println("no tasks to remove");
                }
            } else if (taskMenuChoice.contains("5") || taskMenuChoice.contains("mark")) {
                if (taskList.size() > 0) {
                    markItem();
                } else {
                    System.out.println("no tasks to mark");
                }
            } else if (taskMenuChoice.contains("6") || taskMenuChoice.contains("unmark")) {
                if (taskList.size() > 0) {
                    unmarkItem();
                } else {
                    System.out.println("no tasks to unmark");
                }
            } else if (taskMenuChoice.contains("7") || taskMenuChoice.contains("save")) {
                if (taskList.size() > 0) {
                    saveItems();
                } else {
                    System.out.println("no tasks to save");
                }
            } else if (taskMenuChoice.contains("8") || taskMenuChoice.contains("quit")) {
                TaskApp taskApp = new TaskApp();
                taskApp.run();
            } else {
                System.out.println("Invalid menu option.");
            }
        }
    }

    private void displayOperationMenu() {
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println();
    }

    private void displayItems() {
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println();
        System.out.println(taskList.view());
        System.out.println();
    }

    private void addItem() {
        System.out.print("Task title: ");
        String title = input.nextLine();

        System.out.print("Task description: ");
        String description = input.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = input.nextLine();

        try {
            taskList.add(new TaskItem(title, description, dueDate));
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void editItem() {
        displayItems();

        System.out.print("Which task will you edit? ");
        int index = input.nextInt();
        input.nextLine();

        if (index < taskList.size()) {
            System.out.printf("Enter a new title for task %d: ", index);
            String title = input.nextLine();

            System.out.printf("Enter a new description for task %d: ", index);
            String description = input.nextLine();

            System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: ", index);
            String dueDate = input.nextLine();

            try {
                taskList.update(index, title, description, dueDate);
            } catch(IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("WARNING: invalid task number");
        }
    }

    private void removeItem() {
        displayItems();

        System.out.print("Which task will you remove? ");
        int index = input.nextInt();
        input.nextLine();

        if (index < taskList.size()) {
            taskList.remove(index);
        } else {
            System.out.println("WARNING: invalid task number");
        }
    }

    private void markItem() {
        displayUncompletedItems();

        System.out.print("Which task will you mark as completed? ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= taskList.size()) {
            System.out.println("WARNING: invalid task number");
        } else if (taskList.isTaskComplete(index)) {
            System.out.println("WARNING: task is already complete; no changes made");
        } else {
            taskList.complete(index, true);
        }
    }

    private void displayCompletedItems() {
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println();
        System.out.println(taskList.viewCompletedTasks());
        System.out.println();
    }

    private void unmarkItem() {
        displayCompletedItems();

        System.out.print("Which task will you unmark as completed? ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= taskList.size()) {
            System.out.println("WARNING: invalid task number");
        } else if(!taskList.isTaskComplete(index)) {
            System.out.println("WARNING: task is already incomplete; no changes made");
        } else {
            taskList.complete(index, false);
        }
    }

    private void displayUncompletedItems() {
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        System.out.println();
        System.out.println(taskList.viewUncompletedTasks());
        System.out.println();
    }

    private void saveItems() {
        if (taskList.size() > 0) {
            System.out.print("Enter the filename to save as: ");
            String filename = input.nextLine();
            taskList.save(filename);

            System.out.println("task list has been saved");
        } else {
            System.out.println("no tasks to save");
        }
    }
}
