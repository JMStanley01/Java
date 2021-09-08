package cmsc256;
/**
 * Employee
 * Represents employee information such as office, salary, and date hired while formatted to return
 * a string of said info
 * <p>
 * CMSC Project 1
 *
 * @author Jeffrey Stanley
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Employee extends Person {
    private String office;
    private int salary;
    private LocalDate hireDate;

    //default constructor, sets default values
    public Employee() {
        super();
        office = "Unassigned";
        salary = 0;
        hireDate = null;
    }

    //Parameterized constructor, sets new values if passed in while also validating variables (if possible)
    public Employee(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String office,
                    int salary, int month, int day, int year) {
        super(first, middle, last, homeAddress, phoneNumber, email);
        this.office = office;
        hireDate = LocalDate.of(year, month, day);
        String of = hireDate.getMonthValue() + "/" + hireDate.getDayOfMonth() + "/" + hireDate.getYear();
        setSalary(salary);
        this.salary = salary;
    }

    //returns office value
    public String getOffice() {
        return office;
    }

    //sets office value
    public void setOffice(String office) {
        this.office = office;
    }

    //gets office value
    public int getSalary() {
        return salary;
    }

    //sets office value
    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be less than zero.");
        }
        this.salary = salary;
    }

    //returns hireDate value
    public LocalDate getHireDate() {

        return hireDate;
    }

    //sets hireDate value
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    //returns a formatted string with Employee information
    public String toString() {


        String result = "Employee:" + "\n" + "-----------------\n" + getName() + "\n-----------------" + "\n" +
                "Home Address: " + getHomeAddress() + "\n" + "Phone Number: " + getPhoneNumber() + "\n" +
                "Email Address: " + getEmail() + "\n" + "ID: " + getId() + "\n" + "Office: " + getOffice() + "\n" + "Salary: "
                + getSalary() + "\n" + "Date Hired: " + getHireDate();
        return result;
    }

}
