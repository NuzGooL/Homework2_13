package staffGroup.Homework2_13.model;

import java.util.Objects;

public class Employee {
    private final String firstname;
    private final String lastName;
    private Department department;
    private int salary;

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String firstname, String lastName, Department department, int salary) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getFirstname(), employee.getFirstname()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastName());
    }
}