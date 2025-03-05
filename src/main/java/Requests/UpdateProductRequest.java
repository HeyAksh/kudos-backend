package Requests;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String name;
    private Integer price;
    private String description;
    private String productImageUrl;
}
