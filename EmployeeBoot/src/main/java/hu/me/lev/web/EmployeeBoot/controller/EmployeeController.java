package hu.me.lev.web.EmployeeBoot.controller;

import hu.me.lev.web.EmployeeBoot.exception.EmployeeNotFoundException;
import hu.me.lev.web.EmployeeBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String getEmployee(@RequestParam("id") int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id).toString();
    }
}
