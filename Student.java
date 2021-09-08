package cmsc256;

/**
 * Student
 * Represents student information such as level and formatted to return
 * a string of said info
 * <p>
 * CMSC Project 1
 *
 * @author Jeffrey Stanley
 */
public class Student extends Person {
    private String level;

    //default constructor, sets default values
    public Student() {
        super();
        level = "Freshman";

    }

    //Parameterized constructor, sets new values if passed in while also validating variables (if possible)
    public Student(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String level) {
        super(first, middle, last, homeAddress, phoneNumber, email);

        if (!isValidLevel(level)) {
            throw new IllegalArgumentException("The level cannot be null.");
        }
        this.level = level;

    }

    //gets level of Student
    public String getLevel() {
        return level;
    }

    //sets level
    public void setLevel(String level) {
        this.level = level;
    }

    //validates level value and returns true if valid
    public boolean isValidLevel(String level) {

        String[] levelList = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};

        for (int i = 0; i < levelList.length; i++) {
            if (levelList[i].equals(level))
                return true;
        }
        return false;
    }

    //returns a formatted string with Student information
    public String toString() {
        String result = "Student: " + "\n" + "-----------------\n" + getName() + "\n-----------------" + "\n" +
                "Home Address: " + getHomeAddress() + "\n" + "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" + "ID: " + getId() + "\n" + "Student Level: " + getLevel();
        return result;
    }
}


