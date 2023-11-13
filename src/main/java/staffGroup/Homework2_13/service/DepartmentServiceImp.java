package staffGroup.Homework2_13.service;
import org.springframework.stereotype.Service;
import staffGroup.Homework2_13.Exceptions.DepartmentNotExistExeption;
import staffGroup.Homework2_13.Exceptions.EmployeeNotFoundException;
import staffGroup.Homework2_13.model.Department;
import staffGroup.Homework2_13.model.Employee;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImp implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImp(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public String hello() {
        return "Добро пожаловать в департятор";
    }
    @Override
    public List<Employee> getStaffDepartment(int id) {
        checkId(id);
        return employeeService.getCollectionEmployees().stream()
                .filter(employee -> employee.getDepartment().ordinal() == id-1).collect(Collectors.toUnmodifiableList());
    }
    @Override
    public int getSalarySumDepartment(int id) {
        checkId(id);
        return employeeService.getCollectionEmployees().stream()
                .filter(employee -> employee.getDepartment().ordinal() == id-1)
                .mapToInt(Employee::getSalary).sum();
    }
    @Override
    public int getSalaryMaxDepartment(int id) {
        checkId(id);
        return employeeService.getCollectionEmployees().stream()
                .filter(employee -> employee.getDepartment().ordinal() == id-1)
                .mapToInt(Employee::getSalary).max().orElseThrow(() -> new EmployeeNotFoundException("No Employees in department"));
    }
    @Override
    public int getSalaryMinDepartment(int id) {
        checkId(id);
        return employeeService.getCollectionEmployees().stream()
                .filter(employee -> employee.getDepartment().ordinal() == id-1)
                .mapToInt(Employee::getSalary).min().orElseThrow(() -> new EmployeeNotFoundException("No Employees in department"));
    }
    @Override
    public Map<Integer, List<Employee>> getEmployeersByDepartments() {
        return employeeService.getCollectionEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().ordinal()));
    }
    private static void checkId(int id) {
        if (Arrays.stream(Department.values()).filter(p -> p.ordinal() == id-1).findAny().isEmpty()) {
            throw new DepartmentNotExistExeption("Департамента с таким номером не существует");
        }
    }
}