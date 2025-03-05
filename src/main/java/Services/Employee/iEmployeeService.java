package Services.Employee;

import Model.Employee;
import Model.Event;
import Requests.AddEmployeeRequest;

import java.util.List;

public interface iEmployeeService {
    Employee addEmployee(AddEmployeeRequest request);
    Employee getEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, Employee employee);
    List<Event> getEventsByEmployeeId(Integer id);
}
