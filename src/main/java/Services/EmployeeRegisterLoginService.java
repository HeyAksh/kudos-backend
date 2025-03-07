package Services;

import Model.Employee;
import Requests.AddEmployeeRequest;
import Requests.EmployeeLoginRequest;
import Security.CustomPasswordEncoder;
import Services.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegisterLoginService {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public Employee registerEmployee(AddEmployeeRequest employeeRequest) {
        employeeRequest.setPassword(customPasswordEncoder.encode(employeeRequest.getPassword()));
        return employeeService.addEmployee(employeeRequest);
    }

    public String login(EmployeeLoginRequest loginRequest) {
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        }
        else {
            return null;
        }
    }

}
