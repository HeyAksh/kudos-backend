//package Services.TicketService;
//
//import Model.Ticket;
//import Model.TicketStatus;
//import Repository.TicketRepository;
//import Services.MeetingService.MeetingService;
//import Services.ZoomApiService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class TicketService {
//    private final TicketRepository ticketRepository;
//
//    private final MeetingService meetingService;
//
//    public Ticket createTicket(Ticket ticket) {
//        ticket.setStatus(TicketStatus.ACTIVE);
//        return ticketRepository.save(ticket);
//    }
//
//    public Ticket changeStatus(Integer ticketId, TicketStatus status) {
//        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
//        ticket.setStatus(status);
//
//        if (status == TicketStatus.ONGOING) {
//            meetingService.createMeeting(ticket);
//        }
//
//        return ticketRepository.save(ticket);
//    }
//
//    @Autowired
//    private ZoomApiService zoomApiService;
//
//    public Ticket updateTicketStatus(Long ticketId, String status) {
//        Ticket ticket = ticketRepository.findById(ticketId)
//                .orElseThrow(() -> new RuntimeException("Ticket not found"));
//
//        ticket.setStatus(status);
//        if (status.equals("ONGOING")) {
//            String meetingLink = zoomApiService.createMeeting(ticket.getTitle(), 60);
//            ticket.setMeetingLink(meetingLink);
//        }
//        ticketRepository.save(ticket);
//        return ticket;
//    }
//
//
//}
