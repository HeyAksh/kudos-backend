package Services.Event;

import Model.Event;
import java.util.List;

public interface iEventService {
    Event addEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(Integer eventId);
    boolean deleteEvent(Integer eventId);
    Event updateEvent(Integer eventId, Event updatedEvent);
}
