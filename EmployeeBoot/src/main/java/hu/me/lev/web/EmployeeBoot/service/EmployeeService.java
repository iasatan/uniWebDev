package hu.me.lev.web.EmployeeBoot.service;

import hu.me.lev.web.EmployeeBoot.exception.EmployeeNotFoundException;
import hu.me.lev.web.EmployeeBoot.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(int id) throws EmployeeNotFoundException;

    List getAllEmployee();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmpoyee(Employee employee);
}
