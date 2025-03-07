package Response;

import lombok.Data;

@Data
public class AppStoreResponse {
    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private String category;
    private String image;
}
