package id.ac.ui.cs.adproa3.microservicerequestproduct.service;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.repository.RequestProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RequestProductServiceImpl implements RequestProductService{
    @Autowired
    private RequestProductRepository requestProductRepository;

    @Autowired
    private RestTemplate restTemplate;
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/IDR";

    @Override
    public RequestProduct create(RequestProduct requestProduct) {
        double exchangeRate = fetchExchangeRate(requestProduct.getCurrency(), "IDR");
        double convertedPrice = convertCurrency(requestProduct.getPrice(), exchangeRate);
        requestProduct.setPrice(convertedPrice);
        requestProduct.setCurrency("IDR");

        requestProductRepository.save(requestProduct);
        return requestProduct;
    }


    @Override
    public void delete(UUID id) {
        requestProductRepository.deleteById(id);
    }

    @Override
    public RequestProduct update(UUID id, RequestProduct updatedRequestProduct) {
        Optional<RequestProduct> optionalRequestProduct = requestProductRepository.findById(id);
        if (optionalRequestProduct.isPresent()) {
            RequestProduct requestProduct = optionalRequestProduct.get();
            requestProduct.setName(updatedRequestProduct.getName());
            requestProduct.setPictureUrl(updatedRequestProduct.getPictureUrl());
            requestProduct.setUrl(updatedRequestProduct.getUrl());

            double exchangeRate = fetchExchangeRate(updatedRequestProduct.getCurrency(), "IDR");
            double convertedPrice = convertCurrency(updatedRequestProduct.getPrice(), exchangeRate);
            requestProduct.setPrice(convertedPrice);

            return requestProductRepository.save(requestProduct);
        } else {
            throw new RuntimeException("RequestProduct not found with id: " + id);
        }
    }

    @Override
    public List<RequestProduct> findAll() {
        return requestProductRepository.findAll();
    }

    @Override
    public RequestProduct findById(UUID id) {
        return requestProductRepository.findById(id).orElse(null);
    }

    @Override
    public double fetchExchangeRate(String fromCurrency, String toCurrency) {
        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + fromCurrency;
        Map<String, Object> response = restTemplate.getForObject(urlStr, Map.class);

        if (response != null && response.containsKey("rates")) {
            Map<String, Double> rates = (Map<String, Double>) response.get("rates");
            if (rates != null && rates.containsKey(toCurrency)) {
                return rates.get(toCurrency);
            } else {
                throw new RuntimeException("Currency not found in rates");
            }
        } else {
            throw new RuntimeException("Failed to get exchange rate");
        }
    }

    public double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
