package cmsc256;

/**
 * Staff
 * Represents Staff information such as title and formatted to return
 * a string of said info
 * <p>
 * CMSC Project 1
 *
 * @author Jeffrey Stanley
 */
public class Staff extends Employee {
    private String title;

    //default constructor, sets default values
    public Staff() {
        super();
        title = "None given";
    }

    //Parameterized constructor, sets new values if passed in while also validating variables (if possible)
    public Staff(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                 int salary, int month, int day, int year, String title) {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        this.title = title;


    }

    //gets Title of Staff
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //returns a formatted string with Staff information
    public String toString() {
        String result = "Staff:" + "\n" + "-----------------\n" + getName() + "\n-----------------" + "\n" +
                "Home Address: " + getHomeAddress() + "\n" + "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" + "ID: " + getId() + "\n" + "Office: " + getOffice() +
                "\n" + "Salary: " + getSalary() + "\n" + "Date Hired: " + getHireDate() + "\n" + "Title: " + getTitle();
        return result;
    }
}
