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

@Service
public class EventService implements iEventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

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
}
