package Services.Event;

import Model.Event;
import Requests.AddEventRequest;
import Requests.EventUpdateRequest;
import Response.EventResponse;

import java.util.List;

public interface iEventService {
    EventResponse addEvent(AddEventRequest request);
    List<EventResponse> getAllEvents();
    Event getEventById(Integer eventId);
    void deleteEvent(Integer eventId);
    Long getNumberOfEvents();
    Long getNumberOfActiveEvents();
    Event updateEvent(Integer eventId, EventUpdateRequest request);

}
