package Requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EventUpdateRequest {
    private Integer eventId;
    private String title;
    private String location;
    private String description;
    private String category;
    private String status;
}
