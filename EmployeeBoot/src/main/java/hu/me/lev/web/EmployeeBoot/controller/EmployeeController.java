package hu.me.lev.web.EmployeeBoot.controller;

import hu.me.lev.web.EmployeeBoot.exception.BadEmployeeFormatException;
import hu.me.lev.web.EmployeeBoot.exception.EmployeeNotFoundException;
import hu.me.lev.web.EmployeeBoot.model.Employee;
import hu.me.lev.web.EmployeeBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "asd", method = RequestMethod.GET)
    @ResponseBody
    public String asd() {
        return "asd";
    }

    @GetMapping("getEmployee")
    @ResponseBody
    public Employee getEmployee(@RequestParam("id") int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/addEmployee")
    public String addEmployee(@RequestParam("id") int id,
                              @RequestParam("beka") String name,
                              @RequestParam("age") int age,
                              @RequestParam("salary") int salary) {
        employeeService.addEmployee(new Employee(id, name, age, salary));
        return "redirect:/asd";
    }

    @PostMapping(value = "/AddEmployee", consumes = "application/json")
    public String addEmployeeObj(@Valid @RequestBody Employee employee, BindingResult bindingResult) throws BadEmployeeFormatException {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            throw new BadEmployeeFormatException();
        }

        employeeService.addEmployee(employee);
        return "redirect:/asd";
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String employeeNotFoundHandler() {
        return "No employees found with that id";
    }

    @ExceptionHandler(BadEmployeeFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void badEmployeeExceptionHandler() {

    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {

    }
}
