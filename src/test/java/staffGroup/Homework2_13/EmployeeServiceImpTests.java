package staffGroup.Homework2_13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import staffGroup.Homework2_13.Exceptions.EmployeeAlreadyAddedException;
import staffGroup.Homework2_13.Exceptions.EmployeeNotFoundException;
import staffGroup.Homework2_13.Exceptions.EmployeeStorageIsFullException;
import staffGroup.Homework2_13.model.Employee;
import staffGroup.Homework2_13.service.EmployeeServiceImp;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
public class EmployeeServiceImpTests {
    private EmployeeServiceImp employeeService;
    static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of("Name1", "Surname1", "DEP1", 1000),
                Arguments.of("Name2", "Surname2", "DEP2", 2000),
                Arguments.of("Name3", "Surname3", "DEP3", 3000));
    }
    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImp();
    }
    @Test
    void hello() {
        String actual = employeeService.hello();
        String expected = "Добро пожаловать в эмплойатор";
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void add(String firstname, String lastname, String department, int salary) {

        Employee actual = employeeService.add(firstname, lastname, department, salary);
        assertNotNull(actual);
        assertEquals(firstname, actual.getFirstname());
        assertEquals(lastname, actual.getLastName());
        assertEquals(department, actual.getDepartment().toString());
        assertEquals(salary, actual.getSalary());

        assertTrue(employeeService.getStaffBook().contains(actual));
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void addAlreadyHas(String firstname, String lastname, String department, int salary) {
        Employee actual = employeeService.add(firstname, lastname, department, salary);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstname, lastname, department, salary));
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void addToFull(String firstname, String lastname, String department, int salary) {
        if (employeeService.getStaffBook().isEmpty()) {
            for (int i = 0; i < employeeService.totalPages; i++) {
                employeeService.add("name" + i, "surname" + i, "DEP1", 1);
            }
        }
        assertThrows(EmployeeStorageIsFullException.class, () ->
                employeeService.add(firstname, lastname, department, salary));
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void remove(String firstname, String lastname, String department, int salary) {

        employeeService.add(firstname, lastname, department, salary);
        Employee actual = employeeService.remove(firstname, lastname);
        assertNotNull(actual);
        assertEquals(firstname, actual.getFirstname());
        assertEquals(lastname, actual.getLastName());
        assertEquals(department, actual.getDepartment().toString());
        assertEquals(salary, actual.getSalary());

        assertFalse(employeeService.getStaffBook().contains(actual));
    }
    @ParameterizedTest
    @MethodSource("arguments")
    void removeNotHere(String firstname, String lastname, String department, int salary) {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(firstname, lastname));
    }
}