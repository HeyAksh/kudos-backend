//package Services;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Base64;
//import java.util.Map;
//
//@Service
//public class ZoomTokenService {
//
//    @Value("${zoom.client.id}")
//    private String clientId;
//
//    @Value("${zoom.client.secret}")
//    private String clientSecret;
//
//    @Value("${zoom.account.id}")
//    private String accountId;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public String getAccessToken() {
//        try {
//            String url = "https://zoom.us/oauth/token?grant_type=account_credentials&account_id=" + accountId;
//
//            // Encode clientId:clientSecret into Base64
//            String credentials = clientId + ":" + clientSecret;
//            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
//
//            // Set headers
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Basic " + encodedCredentials);
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//            HttpEntity<String> entity = new HttpEntity<>(headers);
//
//            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
//
//            if (response.getStatusCode() == HttpStatus.OK) {
//                return response.getBody().get("access_token").toString();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
