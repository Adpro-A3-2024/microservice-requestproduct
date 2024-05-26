package id.ac.ui.cs.adproa3.microservicerequestproduct.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RequestProductTest {
    RequestProduct requestProduct;

    @BeforeEach
    void setUp() {
        this.requestProduct = new RequestProduct();
//        this.requestProduct.setId("1");
        this.requestProduct.setName("Gundam");
        this.requestProduct.setUrl("https://actionfigure.com");
        this.requestProduct.setPrice(696969);
        this.requestProduct.setPictureUrl("https://actionfigure.com/image");
    }

//    @Test
//    void testGetRequestProductId() {
//        assertEquals("1", this.requestProduct.getId());
//    }

    @Test
    void testGetProductName() {
        assertEquals("Gundam", this.requestProduct.getName());
    }

    @Test
    void testGetRequestProductPictureUrl() {
        assertEquals("https://actionfigure.com/image", this.requestProduct.getPictureUrl());
    }

    @Test
    void testGetRequestProductPrice() {
        assertEquals(696969, this.requestProduct.getPrice());
    }

    @Test
    void testGetRequestProductUrl() {
        assertEquals("https://actionfigure.com", this.requestProduct.getUrl());
    }
}