package hu.me.lev.controller;

import hu.me.lev.model.Employee;
import hu.me.lev.persist.exception.EmployeeNotFoundException;
import hu.me.lev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/getEmployee")
    public String getEmployee(@RequestParam("id") int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id).toString();
    }


    @RequestMapping
    public String addEmployee(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("salary") int salary) {
        employeeService.addEmployee(new Employee(id, name, age, salary));
        return "OK";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String EmployeeNotFoundExceptionHandler() {
        return "No employee found with that id";
    }
}
