package id.ac.ui.cs.adproa3.microservicerequestproduct.controller;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.service.RequestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request-products")
public class RequestProductController {
    @Autowired
    private RequestProductService requestProductService;

    @PostMapping
    public ResponseEntity<RequestProduct> createRequestProduct(@RequestBody RequestProduct requestProduct) {
        RequestProduct createdRequestProduct = requestProductService.create(requestProduct);
        if (createdRequestProduct != null) {
            return new ResponseEntity<>(createdRequestProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<RequestProduct>> getAllRequestProducts() {
        List<RequestProduct> requestProducts = requestProductService.findAll();
        if (!requestProducts.isEmpty()) {
            return new ResponseEntity<>(requestProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestProduct> getRequestProductById(@PathVariable String id) {
        RequestProduct requestProduct = requestProductService.findById(id);
        if (requestProduct != null) {
            return new ResponseEntity<>(requestProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}