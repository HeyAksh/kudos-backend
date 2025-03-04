package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String firstName;
    private String lastName;

    private String gender;
    private String username;
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "integer default 0")
    private Integer points;

    @ManyToMany(mappedBy = "attendeesList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Event> eventsAttended = new HashSet<>();

    public void attendEvent(Event event) {
        eventsAttended.add(event);
        event.getAttendeesList().add(this);
    }

    public Employee( String firstName, String lastName, String gender,
                    String email, Integer points, Set<Event> eventsAttended) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.points = points;
        this.eventsAttended = eventsAttended;
    }
}
