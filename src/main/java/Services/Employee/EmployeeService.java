package Services.Employee;


import Exceptions.EmployeeNotFoundException;
import Model.Employee;
import Model.Event;
import Repository.EmployeeRepository;
import Repository.EventRepository;
import Requests.AddEmployeeRequest;
import Requests.UpdateEmployeeRequest;
import Services.Event.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EventService eventservice;
    @Autowired
    private EventRepository eventrepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Employee addEmployee(AddEmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        employee.setKudos(0);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee Not Found"));
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return null;
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
        catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException("Employee to be updated does not exist");
        }
        employee = modelMapper.map(request, Employee.class);
        employee.setEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Integer> getEventsByEmployeeId(Integer id) {
        Employee employee = getEmployeeById(id);
        if (employee.getEventsAttended() == null || employee.getEventsAttended().isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(employee.getEventsAttended());
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

    @Override
    public Employee updateKudos(String email, Integer newKudos) {
        Employee employee = employeeRepository.findByEmail(email);
        employee.setKudos(newKudos);
        return employee;
    }

    @Override
    public void registerEvent(String email, Integer eventId) {
        Employee employee = getEmployeeByEmail(email);
        Event event = eventservice.getEventById(eventId);

        employee.attendEvent(eventId);

        employeeRepository.save(employee);
    }

}