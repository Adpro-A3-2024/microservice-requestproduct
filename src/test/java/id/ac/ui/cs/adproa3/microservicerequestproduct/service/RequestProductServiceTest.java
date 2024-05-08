package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.repository.RequestProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequestProductServiceTest {
    @InjectMocks
    RequestProductServiceImpl requestProductService;
    @Mock
    RequestProductRepository requestProductRepository;
    List<RequestProduct> requestProducts;

    @BeforeEach
    void setUp() {
        requestProducts = new ArrayList<>();
        RequestProduct requestProduct = new RequestProduct();
        requestProduct.setId("1");
        requestProduct.setName("Gundam");
        requestProduct.setUrl("https://actionfigure.com");
        requestProduct.setPrice(696969);
        requestProduct.setPictureUrl("https://actionfigure.com/image");
        requestProducts.add(requestProduct);
    }

    @Test
    void testCreateRequestProduct() {
        RequestProduct requestProduct = requestProducts.get(0);
        doReturn(requestProduct).when(requestProductRepository).create(requestProduct);

        RequestProduct result = requestProductService.create(requestProduct);
        verify(requestProductRepository, times(1)).create(requestProduct);
        assertEquals(requestProduct.getId(), result.getId());
    }
}
