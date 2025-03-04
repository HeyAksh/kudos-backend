package Services.Events;

import Model.Events;
import java.util.List;

public interface iEventsService {
    Events addEvent(Integer employeeId, Events event);
    List<Events> getAllEvents();
    Events getEventById(Integer eventId);
    List<Events> getEventsByEmployeeId(Integer employeeId);
    boolean deleteEvent(Integer eventId);
    Events updateEvent(Integer eventId, Events updatedEvent);
}
