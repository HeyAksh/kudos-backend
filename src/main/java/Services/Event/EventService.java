package Services.Event;

import Exceptions.EventNotFoundException;
import Model.Event;
import Repository.EventRepository;
import Requests.AddEventRequest;
import Requests.EventUpdateRequest;
import Response.EventResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EventService implements iEventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EventResponse addEvent(AddEventRequest request) {
        return modelMapper.map(eventRepository.save(modelMapper.map(request,Event.class)), EventResponse.class);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventResponse> eventResponses = new ArrayList<>();

        for (Event event : events) {
            eventResponses.add(modelMapper.map(event, EventResponse.class));
        }

        return eventResponses;
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
    public Long getNumberOfEvents() {
        return eventRepository.count();
    }

    @Override
    public Long getNumberOfActiveEvents() {
        List<Event> events = eventRepository.findAll();
        Long res = 0L;

        for(Event event : events) {
            if (Objects.equals(event.getStatus(), Event.ACTIVE)) {
                res++;
            }
        }

        return res;
    }

    @Override
    public Event updateEvent(Integer eventId, EventUpdateRequest request) {
        Event event = getEventById(eventId);
        event.setTitle(request.getTitle());
        event.setStatus(request.getStatus());
        event.setLocation(request.getLocation());
        event.setCategory(request.getCategory());
        event.setAttendeesList(request.getAttendeesList());
        event.setDate(request.getDate());
        event.setTime(request.getTime());
        event.setId(request.getId());
        event.setImage(request.getImage());
        event.setFeatured(request.isFeatured());
        return eventRepository.save(event);
    }
}
