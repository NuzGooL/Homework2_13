package staffGroup.Homework2_13.service;

import org.springframework.stereotype.Service;
import staffGroup.Homework2_13.Exceptions.EmployeeNotFoundException;
import staffGroup.Homework2_13.model.Employee;
import staffGroup.Homework2_13.model.EmployeeBook;

import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeServiceImp implements EmployeeService {
    public final int totalPages = 10;
    protected EmployeeBook staffBook = new EmployeeBook(totalPages);

    @Override
    public String hello() {
        return "Добро пожаловать в эмплойатор";
    }

    @Override
    public Employee add(String firstname, String lastname, String department, int salary) {
        return staffBook.addEmployee(firstname, lastname, department, salary);
    }

    @Override
    public Employee remove(String firstname, String lastname) {
        return staffBook.remove(firstname, lastname);
    }

    @Override
    public Employee find(String firstname, String lastname) {
        if (!staffBook.getEmployeeBook().containsKey(firstname + lastname)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return staffBook.getEmployeeBook().get(firstname + lastname);
    }

    @Override
    public Collection<Employee> getStaffBook() {
        return Collections.unmodifiableCollection(staffBook.getEmployeeBook().values());
    }
    @Override
    public Collection<Employee> getCollectionEmployees() {
        return staffBook.getEmployeeBook().values();
    }
}