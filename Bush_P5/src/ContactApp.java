import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp extends MainApp {

    private ContactList contactList;

    public static void main(String[] args) {
        ContactApp contactApp = new ContactApp();
        contactApp.run();
    }

    public void run()
    {
        displayContactMenu();
        String in = getMenuChoice();
        if (in.contains("1") || in.contains("create")) {
            createList();
            modifyList();
        } else if (in.contains("2") || in.contains("load")) {
            try {
                loadList();
                modifyList();
            } catch(IllegalArgumentException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (in.contains("3") || in.contains("quit")) {
            mainMenu();
        } else {
            System.out.println("Invalid menu option.");
        }
    }


    private void modifyList() {
        String contactMenuChoice;
        while(true) {
            displayOperationMenu();
            contactMenuChoice = getMenuChoice();

            if (contactMenuChoice.contains("1") || contactMenuChoice.contains("view")) {
                displayItems();
            } else if (contactMenuChoice.contains("2") || contactMenuChoice.contains("add")) {
                addItem();
            } else if (contactMenuChoice.contains("3") || contactMenuChoice.contains("edit")) {

                if (contactList.size() > 0) {
                    editItem();
                } else {
                    System.out.println("no contacts to edit");
                }
            } else if (contactMenuChoice.contains("4") || contactMenuChoice.contains("remove")) {
                if (contactList.size() > 0) {
                    removeItem();
                } else {
                    System.out.println("no contacts to remove");
                }

            } else if (contactMenuChoice.contains("5") || contactMenuChoice.contains("save")) {
                if (contactList.size() > 0) {
                    saveItems();
                } else {
                    System.out.println("no contact to save");
                }
            } else if (contactMenuChoice.contains("6") || contactMenuChoice.contains("quit")) {
                ContactApp contactApp = new ContactApp();
                contactApp.run();
            } else {
                System.out.println("Invalid menu option.");
            }
        }
    }

    private void displayContactMenu() {
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
        contactList = new ContactList();
        System.out.println("new contact list has been created");
    }

    private void loadList() {
        System.out.print("Enter the filename to load: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();

        contactList = new ContactList();
        contactList.load(filename);

        System.out.println("contact list has been loaded");
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println();
    }

    private void displayItems() {
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println();
        System.out.println(contactList.view());
        System.out.println();
    }

    private void addItem() {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        String fName = input.nextLine();

        System.out.print("Last Name: ");
        String lName = input.nextLine();

        System.out.print("Phone Number(xxx-xxx-xxxx): ");
        String fone = input.nextLine();

        System.out.print("Email Address(x@y.z): ");
        String eAdd = input.nextLine();

        try {
            contactList.add(new ContactItem(fName, lName, fone, eAdd));
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void editItem() {
        if(contactList.size() > 0){
            displayItems();
            Scanner input = new Scanner(System.in);
            System.out.print("Which contact will you edit? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < contactList.size()) {
                System.out.printf("Enter a new first name for contact %d: ", index);
                String fName = input.nextLine();

                System.out.printf("Enter a new last name for contact %d: ", index);
                String lName = input.nextLine();

                System.out.printf("Enter a new phone number(xxx-xxx-xxxx) for contact %d: ", index);
                String fone = input.nextLine();

                System.out.printf("Enter a new email address(x@y.z) for contact %d: ", index);
                String eAdd = input.nextLine();

                try {
                    contactList.setter(index, fName, lName, fone, eAdd);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("WARNING: invalid contact number");
            }
        }else{
            throw new IllegalArgumentException("No contacts to edit");
        }
    }

    private void removeItem() {
        if(contactList.size() > 0) {
            displayItems();
            Scanner input = new Scanner(System.in);
            System.out.print("Which contact will you remove? ");
            int index = input.nextInt();
            input.nextLine();

            if (index < contactList.size()) {
                contactList.remove(index);
            } else {
                System.out.println("WARNING: invalid contact number");
            }
        } else
        {
            throw new IllegalArgumentException("No contacts to remove");
        }
    }

    private void saveItems() {
        if (contactList.size() > 0) {
            System.out.print("Enter the filename to save as: ");
            Scanner input = new Scanner(System.in);
            String filename = input.nextLine();
            contactList.save(filename);

            System.out.println("contact list has been saved");
        } else {
            System.out.println("no contacts to save");
        }
    }
}
