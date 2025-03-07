package Requests;

import Model.Employee;
import lombok.Data;

import java.util.Set;

@Data
public class EventUpdateRequest {
    private Integer id;
    private String title;
    private String location;
    private boolean featured;
    private String date;
    private String time;
    private String category;
    private String status;
    private String image;
    private Integer attendees;
    private Set<Employee> attendeesList;
}
