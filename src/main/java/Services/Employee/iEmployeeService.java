package Services.Employee;

import Model.Employee;
import Model.Event;
import Requests.AddEmployeeRequest;
import Requests.UpdateEmployeeRequest;

import java.util.List;

public interface iEmployeeService {
    Employee addEmployee(AddEmployeeRequest request);
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByEmail(String email);
    void deleteEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, UpdateEmployeeRequest employee);
    List<Event> getEventsByEmployeeId(Integer id);
    Integer getKudosByEmailId(String email);
    Employee updateKudos(String email,Integer newKudos);
}
