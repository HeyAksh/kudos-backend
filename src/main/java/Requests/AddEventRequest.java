package Requests;

import Model.Employee;
import lombok.Data;

import java.util.Set;

@Data
public class AddEventRequest {
    private String title;
    private String date;
    private String time;
    private String image;
    private String location;
    private String featured;
    private String category;
    private String status;
    private Integer attendees;
}
