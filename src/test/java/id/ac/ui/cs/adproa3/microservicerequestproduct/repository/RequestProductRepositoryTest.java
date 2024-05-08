package id.ac.ui.cs.adproa3.microservicerequestproduct.repository;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RequestProductRepositoryTest {
    @InjectMocks
    RequestProductRepository requestProductRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCreateAndFind() {
        RequestProduct requestProduct = new RequestProduct();
        requestProduct.setId("1");
        requestProduct.setName("Gundam");
        requestProduct.setUrl("https://actionfigure.com");
        requestProduct.setPrice(696969);
        requestProduct.setPictureUrl("https://actionfigure.com/image");
        requestProductRepository.create(requestProduct);

        Iterator<RequestProduct> iterator = requestProductRepository.findAll();
        assertTrue(iterator.hasNext());
        RequestProduct savedProduct = iterator.next();
        assertEquals(requestProduct.getId(), savedProduct.getId());
        assertEquals(requestProduct.getName(), savedProduct.getName());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<RequestProduct> iterator = requestProductRepository.findAll();
        assertFalse(iterator.hasNext());
    }
}
