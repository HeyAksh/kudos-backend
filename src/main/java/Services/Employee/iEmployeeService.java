package Services.Employee;

import Model.Employee;
import Model.Event;
import Requests.AddEmployeeRequest;
import Requests.UpdateEmployeeRequest;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface iEmployeeService {
    Employee addEmployee(AddEmployeeRequest request);
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByUsername(String email);
    void deleteEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Integer id, UpdateEmployeeRequest employee);
    List<Integer> getEventsByEmployeeId(Integer id);
    Integer getKudosByUsername(String email);
    Employee updateKudos(String email,Integer newKudos);
    void registerEvent(String email,Integer eventId);
}
