package Requests;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddTicketRequest {
    @NotNull
    private Integer id;
    @NotNull
    private String heading;
    @NotNull
    private String description;
    @NotNull
    private String date;
    @NotNull
    private String time;
    @NotNull
    private Integer rewardPoints;
    @NotNull
    private Integer noOfMembers;
    @NotNull
    private String priority;
    @NotNull
    private String status;
}
