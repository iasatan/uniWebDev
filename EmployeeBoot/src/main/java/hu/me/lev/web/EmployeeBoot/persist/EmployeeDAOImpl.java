package hu.me.lev.web.EmployeeBoot.persist;

import hu.me.lev.web.EmployeeBoot.exception.EmployeeNotFoundException;
import hu.me.lev.web.EmployeeBoot.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Map<Integer, Employee> employeeMap;

    public EmployeeDAOImpl() {
        employeeMap = new HashMap<>();
        employeeMap.put(1, new Employee(1, "Adam", 23, 70000));
    }

    @Override
    public Employee selectEmployee(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(id);
    }

    private boolean idInUse(int id) {
        if (employeeMap.containsKey(id)) {
            return true;
        }
        return false;
    }

    @Override
    public List selectEveryEmployee() {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
