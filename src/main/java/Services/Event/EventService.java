package Services.Event;

import Exceptions.EventNotFoundException;
import Model.Event;
import Repository.EventRepository;
import Requests.AddEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements iEventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(AddEventRequest request) {
       return eventRepository.save(helperForEvent(request));
    }

    private Event helperForEvent(AddEventRequest request){
        return new Event(
                request.getTitle(),
                request.getLocation(),
                request.getDescription(),
                request.getFeatured(),
                request.getCategory(),
                request.getStatus(),
                request.getEventImageUrl(),
                request.getAttendeesList()
        );
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(()-> new EventNotFoundException("Event Not Found!"));
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepository.findById(eventId).ifPresentOrElse(eventRepository::delete,
                ()->{throw new EventNotFoundException("Event Not Found!");});
    }


    @Override
    public Event updateEvent(Integer eventId,Event request) {
        Event existingEvent = getEventById(eventId);
        helperForUpdateEvent(existingEvent,request);
        return eventRepository.save(existingEvent);
    }

    private void helperForUpdateEvent(Event existingEvent, Event request){
        existingEvent.setCategory(request.getCategory());
        existingEvent.setDescription(request.getDescription());
        existingEvent.setStatus(request.getStatus());
        existingEvent.setLocation(request.getLocation());
        existingEvent.setTitle(request.getTitle());
        existingEvent.setEventImageUrl(request.getEventImageUrl());
        existingEvent.setFeatured(request.getFeatured());
        existingEvent.setAttendeesList(request.getAttendeesList());
    }
}
