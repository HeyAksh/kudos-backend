package Controller;

import Exceptions.EventNotFoundException;
import Model.Event;
import Response.ApiResponse;
import Response.EventResponse;
import Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/get-all-events")
    public ResponseEntity<ApiResponse> getAllEvents() {
        return ResponseEntity.ok(new ApiResponse("information retrival successfull",
                eventService.getAllEvents()));
    }
}