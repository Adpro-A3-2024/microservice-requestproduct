package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;

import java.util.List;

public interface RequestProductService {
    public RequestProduct create(RequestProduct requestProduct);
    public List<RequestProduct> findAll();
    public RequestProduct findById(String id);
}
