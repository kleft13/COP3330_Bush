import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TaskItemTest {


    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class, ()-> new TaskItem("This","doesn't","work"));
    }

    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, ()-> new TaskItem("","doesn't","2021-02-01"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate(){
        assertDoesNotThrow(()-> new TaskItem("it","does","2021-02-01"));
    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        assertDoesNotThrow(()-> new TaskItem("it","does","2021-02-01"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        item.update("it","weewow","2021-02-01");
        assertEquals("weewow",item.getDescription());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        assertThrows(IllegalArgumentException.class,()-> item.update("it","does","2021"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        assertThrows(IllegalArgumentException.class,()-> item.update("it","does","2021-22-01"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        assertDoesNotThrow(()->item.update("it","does","2025-04-22"));
    }

    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        assertThrows(IllegalArgumentException.class,()-> item.update("","does","2021-02-01"));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("it","does","2021-02-01");
        assertDoesNotThrow(()-> item.update("woopywoo","does","2021-02-01"));
    }
}
