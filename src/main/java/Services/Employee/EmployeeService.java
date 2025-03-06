package Services.Employee;

import Exceptions.EmployeeNotFoundException;
import Exceptions.ProductNotFoundException;
import Model.AppStore;
import Model.Employee;
import Model.Event;
import Repository.EmployeeRepository;
import Requests.AddEmployeeRequest;
import Requests.UpdateEmployeeRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Employee addEmployee(AddEmployeeRequest request) {
        return employeeRepository.save(modelMapper.map(request, Employee.class));
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
        Employee employee;
        try {
            employee = getEmployeeById(id);
        }
        catch (ProductNotFoundException e) {
            throw new EmployeeNotFoundException("Employee to be updated does not exist");
        }
        employee = modelMapper.map(request, Employee.class);
        employee.setEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Event> getEventsByEmployeeId(Integer id) {
        Employee employee = getEmployeeById(id);
        return employee.getEventsAttended().isEmpty() ? null : List.copyOf(employee.getEventsAttended());
    }

    @Override
    public Integer getKudosByEmailId(String email) {
        try {
            Employee employee = employeeRepository.findByEmail(email);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee with email " + email + " not found!");
            }
            return employee.getKudos();
        } catch (EmployeeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Error Occurred while fetching Kudos by Email");
        }
    }
}