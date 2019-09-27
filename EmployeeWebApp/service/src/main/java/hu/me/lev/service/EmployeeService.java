package hu.me.lev.service;

import hu.me.lev.model.Employee;
import hu.me.lev.persist.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(int id) throws EmployeeNotFoundException;

    List getAllEmployee();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmpoyee(Employee employee);
}
