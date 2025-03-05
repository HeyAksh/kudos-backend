package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "appstore")
public class AppStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "productImageUrl")
    private String productImageUrl;

    public AppStore(String name, Integer price, String description, String productImageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productImageUrl = productImageUrl;
    }
}
