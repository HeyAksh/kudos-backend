package Requests;

import Model.Event;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class AddEmployeeRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
}
