package Requests;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddProductRequest {
    private String name;
    private Integer price;
    private String description;
    private String productImageUrl;

}
