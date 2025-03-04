package Model;

import Model.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "events") // lowercase
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventid;

    private String title;
    private String location;
    private Integer attendees;
    private String description;
    private String status;
    private String featured;
    private String category;

    @Lob
    @Column(name = "image", columnDefinition = "BYTEA")
    private byte[] image;

    private String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee; // Back reference for OneToMany
}
