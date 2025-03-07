//package Services.MeetingService;
//
//import Model.Meeting;
//import Model.Ticket;
//import Repository.MeetingRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class MeetingService {
//    private final MeetingRepository meetingRepository;
//
//    public Meeting createMeeting(Ticket ticket) {
//        if (ticket.getStatus().equals("ONGOING")) {
//            Meeting meeting = new Meeting();
//            meeting.setMeetingLink("https://meet.google.com/random-code");
//            meeting.setTicket(ticket);
//
//            return meetingRepository.save(meeting);
//        }
//        return null; // No Meeting for Inactive or Active Tickets
//    }
//
//    @Transactional
//    public void deleteMeeting(Integer ticketId) {
//        meetingRepository.deleteByTicketId(ticketId);
//    }
//}
