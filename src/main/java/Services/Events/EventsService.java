package Services.Events;

import Model.Events;

import java.util.List;

public class EventsService implements iEventsService {
    @Override
    public Events addEvent(Integer employeeId, Events event) {
        return null;
    }

    @Override
    public List<Events> getAllEvents() {
        return List.of();
    }

    @Override
    public Events getEventById(Integer eventId) {
        return null;
    }

    @Override
    public List<Events> getEventsByEmployeeId(Integer employeeId) {
        return List.of();
    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        return false;
    }


    @Override
    public Events updateEvent(Integer eventId, Events updatedEvent) {
        return null;
    }
}
