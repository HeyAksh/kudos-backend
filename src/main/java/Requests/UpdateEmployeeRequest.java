package Requests;

import Model.Event;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateEmployeeRequest {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Integer points;
    private Set<Event> eventsAttended;
}
