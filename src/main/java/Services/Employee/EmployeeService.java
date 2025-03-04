package Services.Employee;

import Model.Employee;

import java.util.List;

public class EmployeeService implements iEmployeeService{
    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return null;
    }
}
