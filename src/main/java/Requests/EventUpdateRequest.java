package Requests;

import Model.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class EventUpdateRequest {
    private String title;
    private String location;
    private String description;
    private String featured;
    private String category;
    private String status;
    private String eventImageUrl;
    private Set<Employee> attendeesList;
}
