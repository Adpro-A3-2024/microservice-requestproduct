package id.ac.ui.cs.adproa3.microservicerequestproduct.model;

import jakarta.persistence.*;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Setter
@Getter
@Table(name = "request_products")
public class RequestProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String pictureUrl;

    @NotNull
    private double price;

    @NotNull
    private String url;

    @NotNull
    private String currency;

    // Constructors

    public RequestProduct() {
    }

    public RequestProduct(String name, String pictureUrl, double price, String url,  String currency) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.url = url;
        this.currency = currency;
    }
}