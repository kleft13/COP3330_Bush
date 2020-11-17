import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskItem extends TaskList
{
    private String title;
    private String desc;
    private String dueDate;

    TaskItem(String title, String desc, String dDate)
    {
        setTitle(title);
        setDesc(desc);
        setDueDate(dDate);
        getTitle();
        getDesc();
        getDueDate();
    }

    public void setDesc(String newDesc) {
        this.desc = newDesc;
    }

    public void setDueDate(String nDueDate) {
        this.dueDate = nDueDate;
    }

    public String setTitle(String newTitle) {
        this.title = newTitle;
        return newTitle;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public String getDueDate()
    {
        return this.dueDate;
    }

    public String toString()
    {
        if((this.desc).equals("") )
        {
            setDesc("No Description given");
        }
        return(dueDate + " " + title + ": " + desc);
    }

    public static void editor(TaskList lister, int i)
    {
        System.out.print("Enter a New Task Title: ");
        Scanner E = new Scanner(System.in);
        String title = E.nextLine();

        System.out.print("Enter a New Task Description: ");
        Scanner F = new Scanner(System.in);
        String desc = F.nextLine();

        System.out.print("Enter a New Task due date (YYYY-MM-DD): ");
        Scanner G = new Scanner(System.in);
        String dD = G.nextLine();
        System.out.print("\n");
        ArrayList<Character> date = new ArrayList <>();
        for (char c :dD.toCharArray())
        {
            date.add(c);
        }
        if (valid(date, title, lister))
        {
            String dateProper = ("[" + dD + "]");
            TaskItem item = new TaskItem(title, desc, dateProper);
            lister.setItem(i, item);
            App.displayListMenu();
            App.checkLM(lister);
        }
    }

    public static void prompt(TaskList lister)
    {
        System.out.print("Task Title: ");
        Scanner E = new Scanner(System.in);
        String title = E.nextLine();

        System.out.print("Task Description: ");
        Scanner F = new Scanner(System.in);
        String desc = F.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        Scanner G = new Scanner(System.in);
        String dDate = G.nextLine();

        ArrayList<Character> date = new ArrayList <>();
        for (char c :dDate.toCharArray())
        {
            date.add(c);
        }
        if (valid(date, title, lister))
        {
            String dateProper = ("[" + dDate + "]");
            TaskItem item = new TaskItem(title, desc, dateProper);
            lister.addToList(item);
            App.displayListMenu();
            App.checkLM(lister);
        }

    }

    public static boolean valid(ArrayList<Character> date, String title, TaskList lister)
    {
        if (title.isEmpty())
        {
            System.out.println("WARNING: title must be at least 1 character long; task not created\n");
            App.runListMenu(lister);
        }
        else {
            if (checkSize(date) && dashCheck(date) && findYear(date) && findMonth(date) && findDay(date))
                return true;
            else
                App.runListMenu(lister);
        }
        return false;
    }

    public static boolean checkSize(ArrayList<Character> chSi)
    {
        if (chSi.size() != 10)
        {
            System.out.println("WARNING: invalid due date; task not created\n");
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean dashCheck(ArrayList<Character> dash)
    {
        int i = 4;
        char c = '-';
        if (dash.get(i).equals(c))
        {
            i += 3;
            if(dash.get(i).equals(c))
            {
                return true;
            }
            else{
                System.out.println("WARNING: invalid due date; task not created\n");
                return false;
            }
        } else {
            System.out.println("WARNING: invalid due date; task not created\n");
            return false;
        }
    }

    public static boolean findYear(ArrayList <Character> year)
    {
        try{
            ArrayList<String> num = new ArrayList<>();
            for (int i = 0; i <= 3; i++) {
                num.add((year.get(i)).toString());
            }

            Integer.parseInt(num.get(0));
            Integer.parseInt(num.get(1));
            Integer.parseInt(num.get(2));
            Integer.parseInt(num.get(3));

        }catch (InputMismatchException e) {
            System.out.println("WARNING: invalid due date; task not created\n");
            return false;
        }
        return true;
    }

    public static boolean findMonth(ArrayList <Character> month)
    {
        try {
            ArrayList <String> num = new ArrayList <>();
            for (int i = 5; i <= 6; i++) {
                num.add((month.get(i)).toString());
            }
            Integer.parseInt(num.get(0));
            Integer.parseInt(num.get(1));

        } catch(InputMismatchException e){
            System.out.println("WARNING: invalid due date; task not created\n");
            return false;
        }
        return true;
    }

    public static boolean findDay(ArrayList <Character> day)
    {
        try{
            ArrayList<String> num = new ArrayList<>();
            for (int i = 8; i < day.size(); i++) {
                num.add((day.get(i)).toString());
            }

            Integer.parseInt(num.get(0));
            Integer.parseInt(num.get(1));

        }catch(InputMismatchException e){
            System.out.println("WARNING: invalid due date; task not created\n");
            return false;
        }
        return true;
    }
}

