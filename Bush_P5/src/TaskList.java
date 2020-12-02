import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TaskList {
    private List<TaskItem> items;

    public TaskList() {
        this.items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public void add(TaskItem item) {
        items.add(item);
    }

    private TaskItem get(int index) {
        return items.get(index);
    }

    public void remove(int index) {
        items.remove(index);
    }

    public String view() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if (item.isComplete()) {
                sb.append(String.format("%d) *** %s%n", i, item));
            } else {
                sb.append(String.format("%d) %s%n", i, item));
            }
        }
        return sb.toString();
    }

    public String viewCompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if (item.isComplete())
                sb.append(String.format("%d) %s%n", i, item));
        }

        return sb.toString();
    }

    public String viewUncompletedTasks() {
        StringBuilder sb = new StringBuilder();
        TaskItem item;
        for (int i = 0; i < this.size(); i++) {
            item = this.get(i);
            if(!item.isComplete())
                sb.append(String.format("%d) %s%n", i, item));
        }

        return sb.toString();
    }

    public void update(int index, String title, String description, String dueDate) {
        this.get(index).update(title, description, dueDate);
    }

    public void complete(int index, boolean completed) {
        try {
            this.get(index).complete(completed);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("This task does not exist");
        }
    }

    public void save(String filename) {
        try (Formatter output = new Formatter(filename)) {
            output.format("tasks%n");
            for(TaskItem item : items) {
                output.format("%s%n", item.getDueDate());
                output.format("%s%n", item.getTitle());
                output.format("%s%n", item.getDescription());
                if (item.isComplete()) {
                    output.format("complete%n");
                } else {
                    output.format("incomplete%n");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(String filename) {
        List<TaskItem> backupList = items;

        items = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get(filename))) {
            String header = input.nextLine();
            if (header.equalsIgnoreCase("tasks")) {
                while(input.hasNext()) {
                    String dueDate = input.nextLine();
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String complete = input.nextLine();

                    TaskItem item = new TaskItem(title, description, dueDate);
                    item.complete(complete.equalsIgnoreCase("complete"));
                    this.add(item);
                }
            } else {
                items = backupList;
                throw new InputMismatchException("WARNING: filename is not a valid task list; no data loaded");
            }
        } catch (FileNotFoundException ex) {
            items = backupList;
            throw new IllegalArgumentException("WARNING: task file not found; no task list loaded");
        } catch (IOException ex) {
            items = backupList;
            throw new IllegalArgumentException("WARNING: error loading task data; no task list loaded");
        }
    }

    public String getTaskTitle(int index) {
        return this.get(index).getTitle();
    }

    public String getTaskDescription(int index) {
        return this.get(index).getDescription();
    }

    public String getTaskDueDate(int index) {
        return this.get(index).getDueDate().toString();
    }

    public boolean isTaskComplete(int index) {
        return this.get(index).isComplete();
    }

}
