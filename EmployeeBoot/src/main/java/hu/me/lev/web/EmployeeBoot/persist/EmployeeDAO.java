package hu.me.lev.web.EmployeeBoot.persist;

import hu.me.lev.web.EmployeeBoot.exception.EmployeeNotFoundException;
import hu.me.lev.web.EmployeeBoot.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee selectEmployee(int id) throws EmployeeNotFoundException;

    List selectEveryEmployee();

    boolean idInUse(int id);

    void updateEmployee(Employee employee);

    void insertEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
