package pl.com.data;

import java.io.Serializable;

public class Employee implements Serializable{

    private static final long serialVersionUID = -8510616098212829088L;
    private String firstName;
    private String lastName;
    private String employeeID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(String firstName, String lastName, String employeeID) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setEmployeeID(employeeID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        return getEmployeeID() != null ? getEmployeeID().equals(employee.getEmployeeID()) : employee.getEmployeeID() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmployeeID() != null ? getEmployeeID().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", Employee ID: " + getEmployeeID();
    }
}
