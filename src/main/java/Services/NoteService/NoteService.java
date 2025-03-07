//package Services.NoteService;
//
//import Model.Note;
//import Model.Ticket;
//import Repository.NoteRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class NoteService {
//    private final NoteRepository noteRepository;
//
//    public Note addNote(Integer ticketId, String content, Integer employeeId) {
//        Note note = new Note();
//        note.setTicket(new Ticket(ticketId));
//        note.setContent(content);
//        note.setEmployeeId(employeeId);
//
//        return noteRepository.save(note);
//    }
//}
