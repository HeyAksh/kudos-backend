package Requests;

import Model.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AddEventRequest {
    private String title;
    private String location;
    private String description;
    private String featured;
    private String category;
    private String status;
    private String eventImageUrl;
    private Set<Employee> attendeesList;
}
