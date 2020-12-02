

public class ContactItem {

    private String fName;
    private String lName;
    private String fone;
    private String eAdd;

    public ContactItem(String fName, String lName, String fone, String eAdd){
        if(fName.isBlank() && lName.isBlank() && fone.isBlank() && eAdd.isBlank())
        {
            throw new IllegalArgumentException("No contact information entered");
        }

        this.fName = fName;
        this.lName = lName;
        this.eAdd = eAdd;
        this.fone = fone;
    }

    public void setter(String fName, String lName, String fone, String eAdd)
    {
        if(fName.isBlank() && lName.isBlank() && fone.isBlank() && eAdd.isBlank())
        {
            throw new IllegalArgumentException("No contact information entered");
        }

        this.fName = fName;
        this.lName = lName;
        this.eAdd = eAdd;
        this.fone = fone;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getFone() {
        return fone;
    }

    public String getEAdd() {
        return eAdd;
    }

    public String toString(){
        return String.format("First name: %s\n Last name: %s\n Phone number: %s\n Email address: %s\n", fName, lName, fone, eAdd);
    }
}
