//package Controller;
//
//import Model.Note;
//import Services.NoteService.NoteService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/notes")
//@RequiredArgsConstructor
//public class NoteController {
//    private final NoteService noteService;
//
//    @PostMapping("/{ticketId}")
//    public Note addNote(@PathVariable Integer ticketId, @RequestBody Note note) {
//        return noteService.addNote(ticketId, note.getContent(), note.getEmployeeId());
//    }
//}
