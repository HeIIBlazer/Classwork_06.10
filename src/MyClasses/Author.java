package MyClasses;

public class Author {
    private String FirstName;
    private String LastName;
    private int BirthYear;

  

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

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int BirthYear) {
        this.BirthYear = BirthYear;
    }

    @Override
    public String toString() {
        return "Author{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", BirthYear=" + BirthYear + '}';
    }
    
}
