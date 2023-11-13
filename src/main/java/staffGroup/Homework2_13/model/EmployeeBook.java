package staffGroup.Homework2_13.model;

import staffGroup.Homework2_13.Exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private Map<String, Employee> employeeBook;
    private final int totalPages;

    public EmployeeBook(int totalPages) {
        if (totalPages < 0) {
            throw new AtLeast2pagesExeption("Число записей в книге не может быть отрицательным");
        }
        if (totalPages < 1) {
            throw new AtLeast2pagesExeption("В книге должна быть хотя бы одна страница");
        }
        this.totalPages = totalPages;
        employeeBook = new HashMap<>();
    }

    public Employee addEmployee(String firstname, String lastName, String department, int salary) {
        try {
            Department.valueOf(department);
        } catch (IllegalArgumentException e) {
            throw new DepartmentNotExistExeption("Департамента с таким именем не существует");
        }
        if (employeeBook.containsKey(firstname + lastName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        } else if (employeeBook.size() == totalPages) {
            throw new EmployeeStorageIsFullException("В книге нет свободных записей");
        } else {
            Employee out = new Employee(firstname, lastName, Department.valueOf(department), salary);
            employeeBook.put(firstname + lastName, out);
            return out;
        }
    }

    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

    public Employee remove(String firstname, String lastname) {
        Employee removeEmployee = employeeBook.remove(firstname + lastname);
        if (removeEmployee == null) {
            throw new EmployeeNotFoundException("Такого сотрудника и не было");
        } else {
            return removeEmployee;
        }
    }
}