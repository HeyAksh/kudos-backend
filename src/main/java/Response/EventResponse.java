package Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class EventResponse {
    private Integer id;
    private String title;
    private String date;
    private String time;
    private String location;
    private String image;
    private String category;
    private Integer attendees;
    private String status;
    private boolean featured;
}
