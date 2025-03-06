package Controller;

import Model.Employee;
import Requests.AddEmployeeRequest;
import Response.ApiResponse;
import Security.CustomPasswordEncoder;
import Services.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterEmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerEmployee(AddEmployeeRequest employeeRequest) {
        try {
            employeeRequest.setPassword(customPasswordEncoder.encode(employeeRequest.getPassword()));
            return ResponseEntity.ok(new ApiResponse("new user created", employeeService.addEmployee(employeeRequest)));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new ApiResponse("User with this email or username already exists", null));
        }
    }
}
