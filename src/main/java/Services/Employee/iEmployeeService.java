package Services.Employee;

import Model.Employee;
import Model.Event;

import java.util.List;

public interface iEmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    boolean deleteEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, Employee employee);
    List<Event> getEventsByEmployeeId(Integer id);
}
