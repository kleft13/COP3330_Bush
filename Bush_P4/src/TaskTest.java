import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest {
    //ItemTasks
    ArrayList<TaskList> lister = new ArrayList<>();
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        ArrayList<Character> ch = new ArrayList<>();
        String date = "[12-12-2020]";
        String title = "title";
        TaskList lister = new TaskList();
        for(int i = 0; i < 10; i++)
        {
            ch.add(date.charAt(i));
        }
        assertEquals("WARNING: invalid due date; task not created\n", TaskItem.valid(ch,title, lister));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {

    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {

    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {

    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {

    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {

    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {

    }

    //TaskList

    @Test
    public void addingTaskItemsIncreasesSize()
    {

    }

    @Test
    public void completingTaskItemChangesStatus()
    {

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {

    }

    @Test
    public void editingTaskItemChangesValues()
    {

    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {

    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {

    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {

    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {

    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {

    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {

    }

    @Test
    public void newTaskListIsEmpty()
    {

    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {

    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList t = new TaskList();
        assertDoesNotThrow(()-> t.loadList("testme"));
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {

    }
}
