//package Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "notes")
//public class Note {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String content;
//
//    @ManyToOne
//    @JoinColumn(name = "ticket_id")
//    private Ticket ticket;
//
//    private Integer employeeId;  // who added the note
//}
