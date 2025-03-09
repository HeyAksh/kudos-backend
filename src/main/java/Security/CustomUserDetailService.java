package Security;

import Exceptions.EmployeeNotFoundException;
import Model.Employee;
import Services.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee;
        try {
            employee = employeeService.getEmployeeByUsername(username);
        } catch (EmployeeNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }

        return User
                .builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .roles(employee.getUsername())
                .build();
    }
}
