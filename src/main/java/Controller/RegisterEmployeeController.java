package Controller;

import Model.Employee;
import Requests.AddEmployeeRequest;
import Security.CustomPasswordEncoder;
import Services.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterEmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;

    @PostMapping("/register")
    public Employee registerEmployee(AddEmployeeRequest employeeRequest) {
        employeeRequest.setPassword(customPasswordEncoder.encode(employeeRequest.getPassword()));
        return employeeService.addEmployee(employeeRequest);
    }
}
