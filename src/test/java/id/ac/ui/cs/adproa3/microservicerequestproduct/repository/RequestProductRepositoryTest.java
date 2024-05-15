package id.ac.ui.cs.adproa3.microservicerequestproduct.repository;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class RequestProductRepositoryTest {
//    @InjectMocks
    RequestProductRepository requestProductRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testCreateAndFind() {
        RequestProduct requestProduct = new RequestProduct();
//        requestProduct.setId("1");
        requestProduct.setName("Gundam");
        requestProduct.setUrl("https://actionfigure.com");
        requestProduct.setPrice(696969);
        requestProduct.setPictureUrl("https://actionfigure.com/image");
        requestProductRepository.save(requestProduct);

        Optional<RequestProduct> savedRequestProduct = requestProductRepository.findById(requestProduct.getId());
        assertThat(savedRequestProduct).isPresent();
    }

    @Test
    void testFindAllIfEmpty() {
        List<RequestProduct> list = requestProductRepository.findAll();
        assertThat(list).hasSize(0);
    }
}
