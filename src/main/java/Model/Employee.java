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
    @NotNull
    @Column(unique = true)
    private String username;
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "integer default 0")
    private Integer kudos;

    @ManyToMany(mappedBy = "attendeesList", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<Event> eventsAttended = new HashSet<>();

    public void attendEvent(Event event) {
        eventsAttended.add(event);
        event.getAttendeesList().add(this);
    }

    public Employee( String firstName, String lastName, String gender,
                    String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }
}
