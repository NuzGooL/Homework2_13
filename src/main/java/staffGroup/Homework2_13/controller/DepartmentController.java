package staffGroup.Homework2_13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import staffGroup.Homework2_13.model.Employee;
import staffGroup.Homework2_13.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String hello() {
        return departmentService.hello();
    }

    @GetMapping("/{id}//salary/sum")
    public int getSalarySumDepartment(@PathVariable int id) {
        return departmentService.getSalarySumDepartment(id);
    }

    @GetMapping("/{id}//salary/max")
    public int getSalaryMaxDepartment(@PathVariable int id) {
        return departmentService.getSalaryMaxDepartment(id);
    }

    @GetMapping("/{id}//salary/min")
    public int getSalaryMinDepartment(@PathVariable int id) {
        return departmentService.getSalaryMinDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeersByDepartments() {
        return departmentService.getEmployeersByDepartments();
    }
}