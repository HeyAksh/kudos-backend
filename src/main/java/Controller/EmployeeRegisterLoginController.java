package Controller;

import Model.Employee;
import Requests.AddEmployeeRequest;
import Requests.EmployeeLoginRequest;
import Response.ApiResponse;
import Services.EmployeeRegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmployeeRegisterLoginController {
    @Autowired
    EmployeeRegisterLoginService employeeRegisterLoginService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerEmployee(@RequestBody AddEmployeeRequest employeeRequest) {
        try {
            Employee employee = employeeRegisterLoginService.registerEmployee(employeeRequest);
            return ResponseEntity.ok(new ApiResponse("new user created", employee));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("User with this username or username already exists", null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody EmployeeLoginRequest loginRequest) {
        String jwttoken = employeeRegisterLoginService.login(loginRequest);
        if (jwttoken != null) {
            return ResponseEntity.ok(new ApiResponse("User Logged in", jwttoken));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse("login failed, wrong username or password", jwttoken));
        }
    }
}
