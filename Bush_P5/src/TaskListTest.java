import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        TaskList lister = new TaskList();
        int x = lister.size();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertEquals(x + 1,lister.size());
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        lister.complete(0,true);
        assertTrue(lister.isTaskComplete(0));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(IndexOutOfBoundsException.class, ()-> lister.complete(1,true));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(IndexOutOfBoundsException.class, ()-> lister.update(1,"item","weewoo","2021-12-12"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        lister.update(0,"item","weewoo","2021-12-12");
        assertEquals("weewoo",lister.getTaskDescription(0));
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2020-10-12");
        lister.add(item);
        lister.update(0,"item","","2021-12-12");
        assertNotEquals("2020-10-12",lister.getTaskDueDate(0));
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.update(0,"","","2021-12-12"));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.update(1,"BOomy","","2021-12-12"));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        lister.update(0,"item","","2021-12-12");
        assertNotEquals("item 1",lister.getTaskTitle(0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.update(0,"item","","2021"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.update(1,"item","","2021-12-12"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.update(0,"item","","2021-22-12"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.getTaskDescription(1));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertDoesNotThrow(()->lister.getTaskDescription(0));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.getTaskDueDate(1));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertDoesNotThrow(()->lister.getTaskDueDate(0));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class, ()->lister.getTaskTitle(1));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertDoesNotThrow(()->lister.getTaskTitle(0));
    }

    @Test
    public void newListIsEmpty(){
        TaskList lister = new TaskList();
        assertEquals(0,lister.size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        int x = lister.size();
        lister.remove(0);
        assertEquals(x - 1,lister.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        assertThrows(Exception.class,()->lister.remove(1));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList lister = new TaskList();
        assertDoesNotThrow(()->lister.load("taskExample.txt"));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        lister.complete(0,true);
        lister.complete(0,false);
        assertFalse(lister.isTaskComplete(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList lister = new TaskList();
        TaskItem item = new TaskItem("item","","2021-12-12");
        lister.add(item);
        lister.complete(0,true);
        lister.complete(0,false);
        assertThrows(Exception.class,()-> lister.isTaskComplete(1));
    }
}
