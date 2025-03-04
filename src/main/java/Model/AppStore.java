package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appstore") // Lowercase table name
public class AppStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // For auto-increment in PostgreSQL
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(name = "image", columnDefinition = "BYTEA")
    private byte[] image;

    @Column(name = "download_url")
    private String downloadUrl;
}
