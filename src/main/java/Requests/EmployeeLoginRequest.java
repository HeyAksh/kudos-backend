package Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeLoginRequest {
    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be empty")
    private String password;
}
