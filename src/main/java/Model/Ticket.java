//package Model;
//
//import Model.Meeting;
//import Model.Note;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "tickets")
//public class Ticket {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String title;
//    private String description;
//    private String registrationType;  // TEAM or INDIVIDUAL
//    private Integer kudosPoints;
//
//    @Enumerated(EnumType.STRING)
//    private TicketStatus status;  // ACTIVE, ONGOING, INACTIVE
//
//    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
//    private Meeting meeting;
//
//    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
//    private List<Note> notes = new ArrayList<>();
//}
