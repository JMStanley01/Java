package cmsc256;
/**
 * Faculty
 * Represents Faculty information such as rank and formatted to return
 * a string of said info
 * <p>
 * CMSC Project 1
 *
 * @author Jeffrey Stanley
 */

import java.lang.IllegalArgumentException;

public class Faculty extends Employee {
    private String rank;

    //default constructor, sets default values
    public Faculty() {
        super();
        rank = "Instructor";

    }

    //Parameterized constructor, sets new values if passed in while also validating variables (if possible)
    public Faculty(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                   int salary, int month, int day, int year, String rank) {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);

        if (!isValidRank(rank)) {
            throw new IllegalArgumentException("The rank cannot be null.");
        }
        this.rank = rank;

    }

    //returns rank
    public String getRank() {
        return rank;
    }

    //sets rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    //Method that returns true if inputted rank is valid
    public boolean isValidRank(String rank) {
        // if (rank == null)
        //  throw new IllegalArgumentException("The rank cannot be null.");
        String[] rankList = {"Adjunct", "Instructor", "Assistant Professor", "Associate Professor", "Professor"};
        for (int i = 0; i < rankList.length; i++) {
            if (rankList[i].equals(rank))
                return true;
        }
        return false;

    }

    //Returns a formatted string with Faculty's information
    public String toString() {
        String result = "Faculty:" + "\n" + "-----------------\n" + getName() + "\n-----------------" + "\n" +
                "Home Address: " + getHomeAddress() + "\n" + "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" + "ID: " + getId() + "\n" + "Office: " +
                getOffice() + "\n" + "Salary: " + getSalary() + "\n" + "Date Hired: " + getHireDate() + "\n" + "Rank: " + getRank();
        return result;
    }
}
