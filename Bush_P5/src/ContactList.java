import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
public class ContactList {
    private List<ContactItem> items;

    public ContactList(){
        this.items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public void add(ContactItem item) {
        items.add(item);
    }

    private ContactItem get(int index) {
        return items.get(index);
    }

    public void remove(int index) {
        items.remove(index);
    }

    public String view() {
        StringBuilder sb = new StringBuilder();
        ContactItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            sb.append(String.format("%d) %s%n", i, item));
        }
        return sb.toString();
    }

    public void setter(int index, String fName, String lName, String fone, String eAdd)
    {
        this.get(index).setter(fName, lName, fone, eAdd);
    }

    public void save(String filename) {
        try (Formatter output = new Formatter(filename)) {
            output.format("contacts%n");
            for(ContactItem item : items) {
                output.format("%s%n", item.getFName());
                output.format("%s%n", item.getLName());
                output.format("%s%n", item.getFone());
                output.format("%s%n", item.getEAdd());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(String filename) {
        List<ContactItem> backupList = items;

        items = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get(filename))) {
            String header = input.nextLine();
            if (header.equalsIgnoreCase("contacts")) {
                while(input.hasNext()) {
                    String fName = input.nextLine();
                    String lName = input.nextLine();
                    String fone = input.nextLine();
                    String eAdd = input.nextLine();

                    ContactItem item = new ContactItem(fName,lName,fone,eAdd);

                    this.add(item);
                }
            } else {
                items = backupList;
                throw new InputMismatchException("WARNING: filename is not a valid contact list; no data loaded");
            }
        } catch (FileNotFoundException ex) {
            items = backupList;
            throw new IllegalArgumentException("WARNING: contact file not found; no contact list loaded");
        } catch (IOException ex) {
            items = backupList;
            throw new IllegalArgumentException("WARNING: error loading contact data; no contact list loaded");
        }
    }
}
