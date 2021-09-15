import java.util.ArrayList;

public class Customer {
    //Instance variables
    private String firstName = "";
    private String lastName;
    private String phone;
    private String email;
    private ArrayList<Donut> donuts = new ArrayList<Donut>();

    //default constructor
    public Customer() {
        this.firstName = null;
        this.lastName = null;
        this.phone = null;
        this.email = null;
    }

    //parameter constructor
    public Customer(String lastName, String firstName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // customer name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Customer phone #
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // customer email
    public void setEmail(String email) {
        this.email = email;
    }

    // Gets names
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // gets phone #
    public String getPhone() {
        return phone;
    }

    // gets email
    public String getEmail() {
        return email;
    }

    // adds donut to total
    public void orderDonut(Donut donut) {
        donuts.add(donut);
    }

    // returns number of donuts
    public int getNumDonut() {
        return donuts.size();
    }

    // returns array
    public ArrayList<Donut> getDonut() {
        return donuts;
    }

    // returns total order string
    public String toString() {
        String result = firstName + " " + lastName + "\n" + phone + "\n" + email + "\n";
        result += "Donut Order:\n";
        for (Donut donut : donuts)
            result += donut.toString();
        return result;
    }

}
