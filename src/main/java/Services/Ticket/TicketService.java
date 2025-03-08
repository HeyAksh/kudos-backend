package Services.Ticket;

import Exceptions.ProductNotFoundException;
import Exceptions.TicketNotFoundException;
import Model.Employee;
import Model.Ticket;
import Repository.TicketRepository;
import Requests.AddTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements iTicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(AddTicketRequest request) {
        Ticket response;
        response.setId(request.getId());
        response.setDate(request.getDate());
        response.setDescription(request.getDescription());
        response.setHeading(request.getHeading());
        response.setPriority(request.getPriority());
        response.setNoOfMembers(request.getNoOfMembers());
        response.setRewardPoints(request.getRewardPoints());
        response.setTime(request.getTime());
    }

    @Override
    public Ticket getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(()-> new TicketNotFoundException("Ticket Not Found"));
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    @Override
    public void updateTicketStatus(Integer ticketId, String status) {

    }

    @Override
    public Integer pointsAwardedForTicket(Integer id) {
        Ticket ticket = getTicketById(id);
        return ticket.getRewardPoints();
    }

    @Override
    public Employee registerEmployeeWithTicketId(Integer id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByEmployee(Integer employeeId) {
        return List.of();
    }

    @Override
    public List<Ticket> getTicketsByEmployeeId(Integer employeeId) {
        return List.of();
    }

    @Override
    public void assignTicketToEmployee(Integer ticketId, Integer employeeId) {

    }

    @Override
    public void removeEmployeeFromTicket(Integer ticketId, Integer employeeId) {

    }
}
