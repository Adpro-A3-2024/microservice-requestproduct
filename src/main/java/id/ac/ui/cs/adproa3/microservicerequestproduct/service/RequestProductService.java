package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;

import java.util.List;
import java.util.UUID;

public interface RequestProductService {
    public RequestProduct create(RequestProduct requestProduct);
    public List<RequestProduct> findAll();
    public RequestProduct findById(UUID id);
    public double fetchExchangeRate(String fromCurrency, String toCurrency);
    public double convertCurrency(double amount, double exchangeRate);
    public void delete(UUID id);
    public RequestProduct update(UUID id, RequestProduct updatedRequestProduct);
    public List<RequestProduct> findByUserId(UUID userId);
}
