package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.repository.RequestProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RequestProductServiceImpl implements RequestProductService{
    @Autowired
    private RequestProductRepository requestProductRepository;

    @Override
    public RequestProduct create(RequestProduct requestProduct) {
        if (requestProductRepository.findById(requestProduct.getId()) == null){
            requestProductRepository.create(requestProduct);
            return requestProduct;
        }
        return null;
    }

    @Override
    public List<RequestProduct> findAll() {
        Iterator<RequestProduct> iterator = requestProductRepository.findAll();
        List<RequestProduct> requestProducts = new ArrayList<>();
        iterator.forEachRemaining(requestProducts::add);
        return requestProducts;
    }

    @Override
    public RequestProduct findById(String id) {
        return requestProductRepository.findById(id);
    }
}
