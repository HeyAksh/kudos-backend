//package Controller;
//
//import Model.Ticket;
//import Model.TicketStatus;
//import Services.TicketService.TicketService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/tickets")
//@RequiredArgsConstructor
//public class TicketController {
//    private final TicketService ticketService;
//
//    @PostMapping
//    public Ticket createTicket(@RequestBody Ticket ticket) {
//        return ticketService.createTicket(ticket);
//    }
//
//    @PutMapping("/{id}/status")
//    public Ticket changeStatus(@PathVariable Integer id, @RequestParam TicketStatus status) {
//        return ticketService.changeStatus(id, status);
//    }
//}
//
