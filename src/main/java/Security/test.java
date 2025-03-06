package Security;

import Model.Employee;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/say-hi")
    public String sayHi() {
        return "SayHi";
    }

    @GetMapping("/employee/say-hi")
    public String sayHiEmployee (){
        return "HiEmployee";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees (){
        return employeeRepository.findAll();
    }
}
