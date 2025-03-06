package Model;

import Requests.AddEventRequest;
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
    private Integer id;
    private String title;
    private String date;
    private String time;
    private String location;
    private String image;
    private String category;
    private Integer attendees;
    private String status;
    private boolean featured;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "event_attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> attendeesList = new HashSet<>();

    public final static String ACTIVE = "active", COMPLETED = "completed", UPCOMING = "upcoming";

    public void addEmployee(Employee employee) {
        attendeesList.add(employee);
        employee.getEventsAttended().add(this);
    }

    public Integer getAttendeesCount() {
        return attendeesList.size();
    }

    public Event( String title, String location, String description, boolean featured,
                  String category, String status, String eventImageUrl, Set<Employee> attendeesList) {
        this.title = title;
        this.location = location;
        this.featured = featured;
        this.category = category;
        this.status = status;
        this.image = eventImageUrl;
        this.attendeesList = attendeesList;
    }
}