package staffGroup.Homework2_13;

import staffGroup.Homework2_13.model.Department;
import staffGroup.Homework2_13.model.Employee;

import java.util.List;
import java.util.Map;

import static staffGroup.Homework2_13.model.Department.*;

public class Constants {
    public static final int MAX_DEP_ID = Department.values().length;
    public static final int MIN_DEP_ID = 1;
    public static final int EMPTY_DEP_ID = 3;
    public static Employee employee1 = new Employee("Name1", "Surname1", DEP1, 1000);
    public static Employee employee2 = new Employee("Name2", "Surname2", DEP2, 1000);
    public static Employee employee3 = new Employee("Name3", "Surname3", DEP2, 2000);
    public static Employee employee4 = new Employee("Name4", "Surname4", DEP5, 3000);
    public static Employee employee5 = new Employee("Name5", "Surname5", DEP5, 4000);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            new Employee("Name1", "Surname1", DEP1, 1000),
            new Employee("Name2", "Surname2", DEP2, 1000),
            new Employee("Name3", "Surname3", DEP2, 2000),
            new Employee("Name4", "Surname4", DEP5, 3000),
            new Employee("Name5", "Surname5", DEP5, 4000));
    public static final Map<Integer, List<Employee>> EMPLOYEE_MAP_BY_DEP = Map.of(
            1, List.of(employee1), 2, List.of(employee2, employee3), 5, List.of(employee4, employee5));

    public static final List<Employee> EMPLOYEE_LIST_MAX_ID = List.of(
            new Employee("Name4", "Surname4", DEP5, 3000),
            new Employee("Name5", "Surname5", DEP5, 4000));
    public static final List<Employee> EMPLOYEE_LIST_MIN_ID = List.of(
            new Employee("Name1", "Surname1", DEP1, 1000));
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_SUM = 1000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_SUM = 7000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_MAX = 4000;
    public static final int EMPLOYEE_LIST_MAX_ID_SALARY_MIN = 3000;
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_MAX = 1000;
    public static final int EMPLOYEE_LIST_MIN_ID_SALARY_MIN = 1000;
}