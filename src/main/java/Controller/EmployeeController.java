package Controller;

import Exceptions.EmployeeNotFoundException;
import Model.Employee;
import Response.ApiResponse;
import Services.Employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/employee")
public class EmployeeController {
    private final EmployeeService employeeservice;


    @GetMapping("/get_employee_by_id/{employeeId}")
    public ResponseEntity<ApiResponse> getEmployeeById(
            @PathVariable("employeeId") Integer id
    ) {
        try {
            Employee response = employeeservice.getEmployeeById(id);
            return ResponseEntity.ok(new ApiResponse("Information Retrieval Successful", response));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse("Employee Not Found", e.getMessage()));
        }
    }

    @GetMapping("/say-hi")
    public String sayHi() {
        return "hi";
    }

    @DeleteMapping("/delete_employee_by_id/{employeeId}")
    public ResponseEntity<ApiResponse> deleteEmployeeById(
            @PathVariable("employeeId") Integer id
    ) {
        try {
            employeeservice.deleteEmployeeById(id);
            return ResponseEntity.ok(new ApiResponse(String.format("Employee with Id %d deleted successfully", id),
                    Collections.emptyMap()));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Employee Not Found", e.getMessage()));
        }
    }


//    @GetMapping("/get_all_employees")
//    public ResponseEntity<ApiResponse> getAllEmployees(){
//        List<Employee> response  = iemployeeservice.getAllEmployees();
//        return ResponseEntity
//
//    }

}
