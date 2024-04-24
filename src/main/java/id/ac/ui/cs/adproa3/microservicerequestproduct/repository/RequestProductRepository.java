package id.ac.ui.cs.adproa3.microservicerequestproduct.repository;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RequestProductRepository {
    private List<RequestProduct> requestProductData = new ArrayList<>();
    static long counter = 0;

    public RequestProduct create(RequestProduct requestProduct) {
        requestProduct.setId(Long.toString(++counter));
        requestProductData.add(requestProduct);
        return requestProduct;
    }

    public Iterator<RequestProduct> findAll() {
        return requestProductData.iterator();
    }
}
