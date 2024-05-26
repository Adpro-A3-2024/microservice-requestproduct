package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.repository.RequestProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RequestProductServiceTest {
    @Mock
    private RequestProductRepository requestProductRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RequestProductServiceImpl requestProductService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        RequestProduct requestProduct = new RequestProduct();
        requestProduct.setName("Test Product");
        requestProduct.setPrice(100.0);
        requestProduct.setCurrency("USD");

        when(requestProductRepository.save(requestProduct)).thenReturn(requestProduct);

        RequestProduct savedProduct = requestProductService.create(requestProduct);

        assertNotNull(savedProduct);
        assertEquals("Test Product", savedProduct.getName());
        assertEquals(100.0, savedProduct.getPrice());
        assertEquals("IDR", savedProduct.getCurrency());
    }

    @Test
    public void testDelete() {
        UUID id = UUID.randomUUID();
        requestProductService.delete(id);
        // Pastikan tidak ada exception yang terjadi
    }

    @Test
    public void testUpdate() {
        UUID id = UUID.randomUUID();
        RequestProduct existingProduct = new RequestProduct();
        existingProduct.setId(id);
        existingProduct.setName("Existing Product");
        existingProduct.setPrice(200.0);
        existingProduct.setCurrency("USD");

        RequestProduct updatedProduct = new RequestProduct();
        updatedProduct.setName("Updated Product");
        updatedProduct.setPrice(300.0);
        updatedProduct.setCurrency("USD");

        when(requestProductRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(requestProductRepository.save(existingProduct)).thenReturn(existingProduct);

        RequestProduct result = requestProductService.update(id, updatedProduct);

        assertNotNull(result);
        assertEquals("Updated Product", result.getName());
        assertEquals(300.0, result.getPrice());
        assertEquals("IDR", result.getCurrency());
    }
}
