package staffGroup.Homework2_13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import staffGroup.Homework2_13.Exceptions.DepartmentNotExistExeption;
import staffGroup.Homework2_13.Exceptions.EmployeeNotFoundException;
import staffGroup.Homework2_13.service.DepartmentServiceImp;
import staffGroup.Homework2_13.service.EmployeeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static staffGroup.Homework2_13.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImpTests {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImp out;

    @Test
    void hello() {
        String actual = out.hello();
        String expected = "Добро пожаловать в департятор";
        assertEquals(expected, actual);
    }

    @Test
    void getStaffDepartment() {
        when(employeeServiceMock.getCollectionEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_LIST_MAX_ID, out.getStaffDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID, out.getStaffDepartment(MIN_DEP_ID));
    }

    @Test
    void getStaffDepartmentNegativ() {
        assertThrows(DepartmentNotExistExeption.class, () -> out.getStaffDepartment(MIN_DEP_ID - 1));
        assertThrows(DepartmentNotExistExeption.class, () -> out.getStaffDepartment(MAX_DEP_ID + 1));
    }

    @Test
    public void getSalarySumDepartment() {
        when(employeeServiceMock.getCollectionEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_SUM, out.getSalarySumDepartment(MIN_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_SUM, out.getSalarySumDepartment(MAX_DEP_ID));
    }

    @Test
    public void getSalarySumDepartmentNegativ() {
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalarySumDepartment(MIN_DEP_ID - 1));
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalarySumDepartment(MAX_DEP_ID + 1));
    }

    @Test
    public void getSalaryMaxDepartment() {
        when(employeeServiceMock.getCollectionEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_MAX, out.getSalaryMaxDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_MAX, out.getSalaryMaxDepartment(MIN_DEP_ID));
    }

    @Test
    public void getSalaryMaxDepartmentNegativ() {
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalaryMaxDepartment(MIN_DEP_ID - 1));
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalaryMaxDepartment(MAX_DEP_ID + 1));
        assertThrows(EmployeeNotFoundException.class, () -> out.getSalaryMaxDepartment(EMPTY_DEP_ID));
    }

    @Test
    public void getSalaryMinDepartment() {
        when(employeeServiceMock.getCollectionEmployees()).thenReturn(EMPLOYEE_LIST);

        assertEquals(EMPLOYEE_LIST_MAX_ID_SALARY_MIN, out.getSalaryMinDepartment(MAX_DEP_ID));
        assertEquals(EMPLOYEE_LIST_MIN_ID_SALARY_MIN, out.getSalaryMinDepartment(MIN_DEP_ID));
    }

    @Test
    public void getSalaryMinDepartmentNegativ() {
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalaryMinDepartment(MIN_DEP_ID - 1));
        assertThrows(DepartmentNotExistExeption.class, () -> out.getSalaryMinDepartment(MAX_DEP_ID + 1));
        assertThrows(EmployeeNotFoundException.class, () -> out.getSalaryMinDepartment(EMPTY_DEP_ID));
    }

    @Test
    public void getEmployeersByDepartments() {
        when(employeeServiceMock.getCollectionEmployees()).thenReturn(EMPLOYEE_LIST);

        assertThat(out.getEmployeersByDepartments().keySet().containsAll(EMPLOYEE_MAP_BY_DEP.keySet()));
        assertThat(out.getEmployeersByDepartments().values().containsAll(EMPLOYEE_MAP_BY_DEP.values()));
    }
}