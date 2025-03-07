package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String status;
    private boolean featured;

    public static final String ACTIVE = "active", COMPLETED = "completed", UPCOMING = "upcoming";

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "event_attendees", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "employee_id")
    private Set<Integer> attendeesList = new HashSet<>();

    public void addEmployee(Employee employee) {
        if (!attendeesList.contains(employee.getEmployeeId())) {
            attendeesList.add(employee.getEmployeeId());
            employee.getEventsAttended().add(this.id); // Store Event ID in Employee
        }
    }

    public Integer getAttendeesCount() {
        return attendeesList.size();
    }

    public Event(String title, String location, boolean featured, String category, String status, String image) {
        this.title = title;
        this.location = location;
        this.featured = featured;
        this.category = category;
        this.status = status;
        this.image = image;
    }
}
