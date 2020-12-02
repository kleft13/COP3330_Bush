import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(Exception.class,()->new ContactItem("","","",""));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        assertDoesNotThrow(()-> new ContactItem("John","Jacobs","453-785-4589",""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        assertDoesNotThrow(()-> new ContactItem("","Jacobs","453-785-4589","JJ@gmail.net"));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        assertDoesNotThrow(()-> new ContactItem("John","","453-785-4589","JJ@gmail.net"));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        assertDoesNotThrow(()-> new ContactItem("John","Jacobs","","JJ@gmail.net"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        assertDoesNotThrow(()-> new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net"));
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertThrows(Exception.class, ()->item.setter("","","",""));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertDoesNotThrow(()->item.setter("John","Jacobs","453-785-4589",""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertDoesNotThrow(()->item.setter("","Jacobs","453-785-4589","JJ@gmail.net"));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertDoesNotThrow(()->item.setter("John","","453-785-4589","JJ@gmail.net"));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertDoesNotThrow(()->item.setter("John","Jacobs","","JJ@gmail.net"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertDoesNotThrow(()->item.setter("Terry","Willams","453-235-4589","TW@gmail.net"));
    }

    @Test
    public void testToString(){
        ContactItem item = new ContactItem("John","Jacobs","453-785-4589","JJ@gmail.net");
        assertEquals("First name: John\n Last name: Jacobs\n Phone number: 453-785-4589\n Email address: JJ@gmail.net\n",item.toString());
        }
}
