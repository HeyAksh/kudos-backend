package Services.Employee;

import Exceptions.EmployeeNotFoundException;
import Model.Employee;
import Model.Event;
import Repository.EmployeeRepository;
import Requests.AddEmployeeRequest;
import Requests.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(AddEmployeeRequest request) {
        return employeeRepository.save(helperAddEmployee(request));
    }

    private Employee helperAddEmployee(AddEmployeeRequest request){
        return new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getEmail(),
                request.getPoints(),
                request.getEventsAttended()
        );
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found"));
    }

    @Override
    public void deleteEmployeeById(Integer id) {
       employeeRepository.findById(id).ifPresentOrElse(employeeRepository::delete,
               ()->{throw new EmployeeNotFoundException("Employee Not Found!");});
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, UpdateEmployeeRequest request) {
        Employee existingEmployee = getEmployeeById(id);
        helperUpdateEmployee(existingEmployee,request);
        return employeeRepository.save(existingEmployee);
    }

    private void helperUpdateEmployee(Employee existingEmployee , UpdateEmployeeRequest request){
        existingEmployee.setGender(request.getGender());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setFirstName(request.getFirstName());
        existingEmployee.setPoints(request.getPoints());
        existingEmployee.setLastName(request.getLastName());
        existingEmployee.setEventsAttended(request.getEventsAttended());
    }

    @Override
    public List<Event> getEventsByEmployeeId(Integer id) {
        Employee employee = getEmployeeById(id);
        return employee.getEventsAttended().isEmpty() ? null : List.copyOf(employee.getEventsAttended());
    }
}
