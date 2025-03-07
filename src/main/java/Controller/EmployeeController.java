package Controller;

import Dtos.RegisterEvent;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EventNotFoundException;
import Exceptions.EventRegistrationFailed;
import Model.Employee;
import Requests.AddEmployeeRequest;
import Requests.GetKudos;
import Requests.UpdateEmployeeRequest;
import Response.ApiResponse;
import Services.Employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeservice;

    @GetMapping("/get-employee-by-id/{employeeId}")
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

    @DeleteMapping("/delete-employee-by-id/{employeeId}")
    public ResponseEntity<ApiResponse> deleteEmployeeById(
            @PathVariable("employeeId") Integer id
    ) {
        try {
            employeeservice.deleteEmployeeById(id);
            return ResponseEntity.ok(new ApiResponse(String.format("Employee with Id %d deleted successfully", id),
                    Collections.emptyMap()));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse("Employee Not Found", e.getMessage()));
        }
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<ApiResponse> getAllEmployees() {
        try {
            List<Employee> response = employeeservice.getAllEmployees();
            return ResponseEntity.ok(new ApiResponse("Information Retrieval Successful", response));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponse("No Content Found", e.getMessage()));
        }
    }

    @GetMapping("/get-events-by-employee-id/{employeeId}")
    public ResponseEntity<ApiResponse> getEventsByEmployeeId(
            @PathVariable("employeeId") Integer id
    ) {
        try {
            List<Integer> response = employeeservice.getEventsByEmployeeId(id);
            return ResponseEntity.ok(new ApiResponse("Information Retrieval Successful", response));
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse("Events Not Found", e.getMessage()));
        }
    }

    @PostMapping("/add-employee")
    public ResponseEntity<ApiResponse> addEmployee(
            @Valid @RequestBody AddEmployeeRequest request
    ){
        try {
            Employee response = employeeservice.addEmployee(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("Employee Added Successfully", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to Add Employee", e.getMessage()));
        }
    }


    @PutMapping("/update-employee/{employeeId}")
    public ResponseEntity<ApiResponse> updateEmployee(
            @PathVariable("employeeId") Integer id,
            @Valid @RequestBody UpdateEmployeeRequest request
    ) {
        try {
            Employee response = employeeservice.updateEmployee(id, request);
            return ResponseEntity.ok(new ApiResponse("Updated Information of Employee", response));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse("Employee Not Found", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to update employee", e.getMessage()));
        }
    }

    @GetMapping("/get-kudos-from-emailId/{emailId}")
    public ResponseEntity<ApiResponse> getKudos(
            @PathVariable("emailId") String email
    ){
        try {
            Integer kudos = employeeservice.getKudosByEmailId(email);
            return ResponseEntity.ok(new ApiResponse("Information Fetched Successfully",kudos));
        } catch (Exception e) {
            return  ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Error Occured",e.getMessage()));
        }
    }

    @PutMapping("update-kudos")
    public ResponseEntity<ApiResponse> updateKudos(
            @Valid @RequestBody GetKudos getkudos
            ){
        try {
            Employee response = employeeservice.updateKudos(getkudos.getEmail(),getkudos.getNewKudos());
            return ResponseEntity.ok(new ApiResponse("Kudos Updated Successfully",response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to Update Kudos",e.getMessage()));
        }
    }

    @PutMapping("/register-event")
    public ResponseEntity<ApiResponse> registerEvent(@RequestBody RegisterEvent request) {
        try {
            employeeservice.registerEvent(request.getEmail(), request.getEventId());
            return ResponseEntity.ok(new ApiResponse("Event Registration Successful", null));
        } catch (EventRegistrationFailed e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Event Registration Failed", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Invalid Request", e.getMessage()));
        }
    }
}
