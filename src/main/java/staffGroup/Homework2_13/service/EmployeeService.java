package staffGroup.Homework2_13.service;

import staffGroup.Homework2_13.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, String department, int salary);

    Collection<Employee> getStaffBook();

    String hello();

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getCollectionEmployees();
}