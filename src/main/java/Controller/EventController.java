package Controller;

import Dtos.IntegerId;
import Model.Event;
import Requests.AddEventRequest;
import Requests.EventUpdateRequest;
import Response.ApiResponse;
import Response.EventResponse;
import Services.Event.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private  EventService eventService;

    @GetMapping("/get-all-events")
    public ResponseEntity<ApiResponse> getAllEvents() {
        return ResponseEntity.ok(new ApiResponse("information retrival successfull",
                eventService.getAllEvents()));
    }

    @GetMapping("/get-total-number-of-events")
    public ResponseEntity<ApiResponse> getNumberOfEvents() {
        return ResponseEntity.ok(new ApiResponse("information retrival successfull",
                eventService.getNumberOfEvents()));
    }

    @GetMapping("/get-number-of-active-events")
    public ResponseEntity<ApiResponse> getNumberOfActiveEvents() {
        return ResponseEntity.ok(new ApiResponse("information retrival successfull",
                eventService.getNumberOfActiveEvents()));
    }

    @PostMapping("/add-event")
    public ResponseEntity<ApiResponse> addEvent(
            @Valid @RequestBody AddEventRequest request
            ){
        try {
            EventResponse response = eventService.addEvent(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("Event Added Successfully",response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed to Add Event",e.getMessage()));
        }
    }

    @PutMapping("/update-event-by-id")
    public ResponseEntity<ApiResponse> updateEvent(
            @RequestBody IntegerId integerid,
            @Valid @RequestBody EventUpdateRequest request
            ){
        try {
            Event response = eventService.updateEvent(integerid.getId(),request);
            return ResponseEntity.ok(new ApiResponse("Event Information Updated Successfully",response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed To Update Event Information",e.getMessage()));
        }
    }

}