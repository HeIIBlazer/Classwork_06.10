package MyClasses;
public class Reader {
   private String FirstName;
   private String LastName;
   private String Phone;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Reader{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + '}';
    }

    }
   
   

