package id.ac.ui.cs.adproa3.microservicerequestproduct.model;

import jakarta.persistence.*;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Setter
@Getter
@Table(name = "request_products")
public class RequestProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String pictureUrl;

    @NotNull
    private double price;

    @NotNull
    private String url;

    // Constructors

    public RequestProduct() {
    }

    public RequestProduct(String name, String pictureUrl, double price, String url) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.url = url;
    }

    // Getters and setters

//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPictureUrl() {
//        return pictureUrl;
//    }
//
//    public void setPictureUrl(String pictureUrl) {
//        this.pictureUrl = pictureUrl;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
}