package Services.Ticket;

import Model.Employee;
import Model.Ticket;
import Requests.AddTicketRequest;

import java.util.List;

public interface iTicketService {
    Ticket addTicket(AddTicketRequest request);
    Ticket getTicketById(Integer ticketId);
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByStatus(String status);
    void updateTicketStatus(Integer ticketId, String status);
    Integer pointsAwardedForTicket(Integer ticketId);
    Employee registerEmployeeWithTicketId(Integer ticketId);
    List<Ticket> getTicketsByEmployee(Integer employeeId);
    void assignTicketToEmployee(Integer ticketId, Integer employeeId);
    void removeEmployeeFromTicket(Integer ticketId, Integer employeeId);
}
