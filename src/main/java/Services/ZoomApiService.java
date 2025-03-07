//package Services;
//
//import lombok.RequiredArgsConstructor;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class ZoomApiService {
//
//    @Value("${zoom.api.base-url}")
//    private String baseUrl;
//
//    @Value("${zoom.api.email}")
//    private String email;
//
//    private final ZoomTokenService zoomTokenService;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public String generateMeetingLink(String topic, String startTime) {
//        try {
//            String url = baseUrl + "/users/" + email + "/meetings";
//            String accessToken = zoomTokenService.getAccessToken();
//
//            if (accessToken == null) {
//                throw new RuntimeException("Zoom Access Token is null");
//            }
//
//            Map<String, Object> requestBody = new HashMap<>();
//            requestBody.put("topic", topic);
//            requestBody.put("type", 2); // Scheduled Meeting
//            requestBody.put("start_time", startTime);
//            requestBody.put("duration", 60); // Default 1 hour
//            requestBody.put("timezone", "Asia/Kolkata");
//
//            JSONObject request = new JSONObject(requestBody);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Bearer " + accessToken);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
//
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//
//            if (response.getStatusCode() == HttpStatus.CREATED) {
//                JSONObject jsonResponse = new JSONObject(response.getBody());
//                return jsonResponse.getString("join_url");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public String createMeeting(String title, String startTime) {
//        return generateMeetingLink(title, startTime);
//    }
//}
