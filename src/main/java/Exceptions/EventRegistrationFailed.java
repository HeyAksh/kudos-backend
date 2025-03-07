package Exceptions;

public class EventRegistrationFailed extends RuntimeException {
    public EventRegistrationFailed(String message){
        super(message);
    }
}
