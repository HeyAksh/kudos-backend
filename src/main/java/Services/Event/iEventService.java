package Services.Event;

import Model.Event;
import Requests.AddEventRequest;

import java.util.List;

public interface iEventService {
    Event addEvent(AddEventRequest request);
    List<Event> getAllEvents();
    Event getEventById(Integer eventId);
    void deleteEvent(Integer eventId);
    Event updateEvent(Integer eventId,Event request);
}
