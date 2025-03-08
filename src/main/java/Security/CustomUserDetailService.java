package Security;

import Model.Employee;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);

        if (employee.isEmpty()) {
            throw new UsernameNotFoundException("user with the name " + username + " does not exist");
        }

        return User
                .builder()
                .username(employee.get().getUsername())
                .password(employee.get().getPassword())
                .roles(employee.get().getUsername())
                .build();
    }
}
