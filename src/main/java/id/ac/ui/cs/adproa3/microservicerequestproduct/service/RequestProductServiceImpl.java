package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.repository.RequestProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class RequestProductServiceImpl implements RequestProductService{
    @Autowired
    private RequestProductRepository requestProductRepository;

    @Override
    public RequestProduct create(RequestProduct requestProduct) {
        requestProductRepository.save(requestProduct);
        return requestProduct;
    }

    @Override
    public List<RequestProduct> findAll() {
        return requestProductRepository.findAll();
    }

    @Override
    public RequestProduct findById(Long id) {
        return requestProductRepository.findById(id).orElse(null);
    }
}
