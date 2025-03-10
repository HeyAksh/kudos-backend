package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Ticket")
public class Ticket {
    @Id
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
