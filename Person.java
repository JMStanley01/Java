package cmsc256;

/**
 * Person
 * Represents the parent/grandparent class to most of the other classes and formats information to return
 * a string of said info to any class that may call it.
 * <p>
 * CMSC Project 1
 *
 * @author Jeffrey Stanley
 */
public class Person {
    private int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    static int recordNumber;

    //default constructor, sets default values
    public Person() {
        phoneNumber = "None given";
        email = "None given";
        name = new Name();
        homeAddress = new Address();
        id = ++recordNumber;

    }

    //Parameterized constructor of Person class
    public Person(String first, String middle, String last, Address homeAddress, String phoneNumber, String email) {

        name = new Name(first, middle, last);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        id = ++recordNumber;
    }

    //method to return an individual's address
    public Address getHomeAddress() {
        return homeAddress;
    }

    // sets address
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    //returns phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // sets phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //returns email
    public String getEmail() {
        return email;
    }

    //sets email
    public void setEmail(String email) {
        this.email = email;
    }

    // returns id variable when called.
    public int getId() {
        return id;
    }

    //returns string name when called
    public String getName() {
        return String.valueOf(name);
    }

    //sets name variable
    public void setName(Name name) {
        this.name = name;
    }

    //returns a formatted string with Person information
    public String toString() {
        String result = "Person: " + "\n-----------------\n" + getName() + "\n" + "-----------------" + "\n" + "Home Address: " + getHomeAddress() + "\n" + "Phone Number: " +
                getPhoneNumber() + "\n" + "Email Address: " + getEmail() + "\n" + "ID: " + getId();
        return result;
    }

}
