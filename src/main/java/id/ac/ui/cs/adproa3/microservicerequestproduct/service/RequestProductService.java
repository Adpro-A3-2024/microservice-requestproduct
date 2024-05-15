package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;

import java.util.List;
import java.util.UUID;

public interface RequestProductService {
    public RequestProduct create(RequestProduct requestProduct);
    public List<RequestProduct> findAll();
    public RequestProduct findById(Long id);
}
