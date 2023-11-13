package staffGroup.Homework2_13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import staffGroup.Homework2_13.model.Employee;
import staffGroup.Homework2_13.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String hello() {
        return employeeService.hello();
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("deparment") String department, @RequestParam("salary") int salary) {
        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/book")
    public Collection<Employee> book() {
        return employeeService.getStaffBook();
    }
}