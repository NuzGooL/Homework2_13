package staffGroup.Homework2_13.service;

import staffGroup.Homework2_13.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    String hello();

    List<Employee> getStaffDepartment(int id);

    int getSalarySumDepartment(int id);

    int getSalaryMaxDepartment(int id);

    int getSalaryMinDepartment(int id);

    Map<Integer, List<Employee>> getEmployeersByDepartments();
}
