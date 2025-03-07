//package Controller;
//
//import Model.Meeting;
//import Repository.MeetingRepository;
//import Services.MeetingService.MeetingService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/meetings")
//@RequiredArgsConstructor
//public class MeetingController {
//    private final MeetingService meetingService;
//    private final MeetingRepository meetingRepository;
//
//    @GetMapping("/{ticketId}")
//    public ResponseEntity<Meeting> getMeetingByTicket(@PathVariable Integer ticketId) {
//        Optional<Meeting> meeting = meetingRepository.findByTicketId(ticketId);
//
//        if (meeting.isPresent()) {
//            return ResponseEntity.ok(meeting.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @PostMapping("/create/{ticketId}")
//    public ResponseEntity<Meeting> createMeeting(@PathVariable Integer ticketId) {
//        Meeting meeting = meetingService.createMeeting(ticketId);
//        return ResponseEntity.ok(meeting);
//    }
//
//    @DeleteMapping("/delete/{ticketId}")
//    public ResponseEntity<Void> deleteMeeting(@PathVariable Integer ticketId) {
//        meetingService.deleteMeeting(ticketId);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//}
//
//
//
