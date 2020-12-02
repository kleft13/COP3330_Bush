import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactList lister = new ContactList();
        int x = lister.size();
        ContactItem item = new ContactItem("Joe","","","");
        lister.add(item);
        assertEquals(x + 1,lister.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("Joe","","","");
        lister.add(item);
        assertThrows(Exception.class, ()-> lister.setter(0,"","","",""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("Joe","","","");
        lister.add(item);
        assertThrows(Exception.class, ()-> lister.setter(1,"Dan","","",""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("","Jacobs","","");
        lister.add(item);
        assertDoesNotThrow(()->lister.setter(0,"","Williams","",""));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("Jacob","","","");
        lister.add(item);
        assertDoesNotThrow(()->lister.setter(0,"William","","",""));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("","Jacobs","","");
        lister.add(item);
        assertDoesNotThrow(()->lister.setter(0,"","Williams","",""));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("John","Jacobs","407-824-5863","excel@butter.com");
        lister.add(item);
        assertDoesNotThrow(()->lister.setter(0,"Terry","Williams","321-423-4565","wheel@burrow.net"));
    }

    @Test
    public void newListIsEmpty(){
        ContactList lister = new ContactList();
        assertEquals(0,lister.size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("Joe","","","");
        lister.add(item);
        int x = lister.size();
        lister.remove(0);
        assertEquals(x - 1,lister.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList lister = new ContactList();
        ContactItem item = new ContactItem("Joe","","","");
        lister.add(item);
        assertThrows(Exception.class,()->lister.remove(1));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList lister = new ContactList();
        assertDoesNotThrow(()->lister.load("contactExample.txt"));
    }

}
