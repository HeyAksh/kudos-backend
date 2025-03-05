package Services.Event;

import Model.Event;
import Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements iEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.orElse(null);
    }

    @Override
    public boolean deleteEvent(Integer eventId) {
        return false;
    }


    @Override
    public Event updateEvent(Integer eventId, Event updatedEvent) {
        return null;
    }
}
