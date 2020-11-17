import java.io.*;
import java.util.*;

public class TaskList
{
    ArrayList<TaskList> lister = new ArrayList<>();
    ArrayList<TaskList> completed = new ArrayList<>();
    ArrayList<TaskList> uncompleted = new ArrayList<>();

    public void addToList(TaskItem item) {
        lister.add(item);
    }

    public int listSize() {
        return lister.size();
    }

    public int uncomSize()
    {
        return uncompleted.size();
    }

    public TaskItem getItem(int i) {
        return (TaskItem) lister.get(i);
    }

    public void listList() {
        System.out.println("Current Tasks");
        System.out.println("--------------");
        for (int i = 0; i < listSize(); i++) {
            System.out.println(i + ") " + ((getItem(i)).toString()));
        }
        System.out.println("\n");
    }

    public void editItems( TaskList lister) {
        if (listSize() == 0) {
            System.out.println("There are no Tasks in your List\n");
        } else {
            listList();
            System.out.print("Which task will you edit: ");
            Scanner again = new Scanner(System.in);
            String res = again.nextLine();
            if (isNumeric(res))
            {
                int num = Integer.parseInt(res);
                getItem(num);
                TaskItem.editor(lister, num);
            }
            else
            {
                System.out.print("no item edited");
            }
        }
    }

    public void deleteItem()
    {
        if (listSize() == 0) {
            System.out.println("There are no Tasks in your List\n");
        } else {
            listList();
            System.out.print("Which task will you edit: ");
            Scanner again = new Scanner(System.in);
            String res = again.nextLine();
            if (isNumeric(res))
            {
                int num = Integer.parseInt(res);
                lister.remove(num);
            }
            else
            {
                System.out.print("no item deleted");
            }
        }
    }

    public void setItem(int i, TaskItem item)
    {
        getItem(i);
        lister.set(i, item);
    }
    public boolean isNumeric(String mbyNm)
    {
        try{
            Integer.parseInt(mbyNm);
        }catch(InputMismatchException e){
            System.out.println("Invaild item selection, ");
            return false;
        }
        return true;
    }

    public void markComp()
    {
        listUncom();
        System.out.print("Which task would you like to mark as completed?: ");
        Scanner again = new Scanner(System.in);
        String res = again.nextLine();
        if (isNumeric(res)) {
            try {
                int num = Integer.parseInt(res);
                completed.add(uncompleted.get(num));
                uncompleted.remove(num);
                getItem(num).setDueDate("***" + getItem(num).getDueDate());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("This task does not exist\n");
            }
        }
        else
        {
            System.out.print("no item was selected");
        }
    }

    public void unmarkComp()
    {
        listCom();
        System.out.print("Which task would you like to unmark?: ");
        Scanner again = new Scanner(System.in);
        String res = again.nextLine();
        if (isNumeric(res)) {
            try {
                int num = Integer.parseInt(res);
                shiftItems(num);
                //find task
                getItem(num).setDueDate((getItem(num).getDueDate()).substring(3));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("This task does not exist\n");
            }
        }
        else
        {
            System.out.print("no item was selected");
        }
    }

    private void shiftItems(int x)
    {
        uncompleted.add(getItem(x));
        for(int i = uncompleted.size() - 1; i > 0; i--)
        {
            uncompleted.add(i + 1, uncompleted.get(i));
        }
    }

    public void listCom()
    {
        if(!completed.isEmpty()) {
            System.out.println("Current Completed Tasks");
            System.out.println("-----------------------");
            for (int i = 0; i < completed.size(); i++) {
                System.out.println(i + ") " + (completed.get(i)));
            }
        }else{
            System.out.println("There are no tasks completed\n");
        }
    }

    public void listUncom()
    {
        System.out.println("Current Uncompleted Tasks");
        System.out.println("-------------------------");
        try {

            for (int i = 0; i < listSize(); i++)
            {
                if (!isTaskCompleted(i)) {
                    if(!isTaskUncomplete(i)) {
                        uncompleted.add(lister.get(i));
                    }
                }
                System.out.println(i + ") " + (uncompleted.get(i)));
            }
            System.out.println("\n");

        } catch (IndexOutOfBoundsException e){
            System.out.println("Out of Bound!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isTaskUncomplete(int i) {
        if (!uncompleted.isEmpty()) {
            for (TaskList taskList : uncompleted) {
                return taskList.equals(lister.get(i));
            }
        }
        return false;
    }

    private boolean isTaskCompleted(int i)
    {
        if (!completed.isEmpty()) {
            for (TaskList taskList : completed) {
                return taskList.equals(lister.get(i));
            }
        }
        return false;
    }

    public void saveList() {
        System.out.print("What would you like to call the file?: ");
        Scanner again = new Scanner(System.in);
        String res = again.nextLine();
        String fle = res + ".txt";
        writeIt(fle);
    }

    public void writeIt(String filename) {
        try (Formatter output = new Formatter(filename)) {
            for (int i = 0; i < lister.size(); i++) {
                output.format("%s\n%s\n%s\n",getItem(i).getDueDate(), getItem(i).getTitle(), getItem(i).getDesc());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadList(String file)
    {
        String fullDate, fTitle, fDesc;
        ArrayList<String> ugh = new ArrayList<>();
        try {
            File listy = new File(file);
            Scanner read = new Scanner(listy);
            while (read.hasNextLine()) {
                ugh.add(read.nextLine());
                ugh.add(read.nextLine());
                ugh.add(read.nextLine());
            }
            for(int i = 0; i < (ugh.size()); i+= 3)
            {
                fullDate = ugh.get(i);
                fTitle = ugh.get(i + 1);
                fDesc = ugh.get(i + 2);
                TaskItem item = new TaskItem(fTitle, fDesc, fullDate);
                addToList(item);
            }
            System.out.println("file loaded\n");
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist");
            e.printStackTrace();
        }
    }


    public void checkAllUncom()
    {
        for(int i = 0; i < uncomSize(); i++)
        {
            for(int x = 0; x < listSize(); x++)
            {
                if(!uncompleted.get(i).equals(lister.get(x))){
                    uncompleted.remove(lister.get(i));
                }
            }
        }
    }
}
