package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    private String title;
    private String location;
    private String description;
    private String featured;
    private String category;
    private String status;
    private String eventImageUrl;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "event_attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> attendeesList = new HashSet<>();

    public void addEmployee(Employee employee) {
        attendeesList.add(employee);
        employee.getEventsAttended().add(this);
    }

    public Integer getAttendeesCount() {
        return attendeesList.size();
    }

    public Event( String title, String location, String description, String featured,
                  String category, String status, String eventImageUrl, Set<Employee> attendeesList) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.featured = featured;
        this.category = category;
        this.status = status;
        this.eventImageUrl = eventImageUrl;
        this.attendeesList = attendeesList;
    }
}