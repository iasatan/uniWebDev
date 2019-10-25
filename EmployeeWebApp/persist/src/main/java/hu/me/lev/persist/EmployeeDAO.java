package hu.me.lev.persist;

import hu.me.lev.model.Employee;
import hu.me.lev.persist.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDAO {

    Employee selectEmployee(int id) throws EmployeeNotFoundException;

    List selectEveryEmployee();

    void updateEmployee(Employee employee);

    void insertEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
