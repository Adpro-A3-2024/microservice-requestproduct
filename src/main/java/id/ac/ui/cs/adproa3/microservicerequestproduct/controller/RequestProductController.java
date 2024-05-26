package id.ac.ui.cs.adproa3.microservicerequestproduct.controller;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import id.ac.ui.cs.adproa3.microservicerequestproduct.service.RequestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/request-product")
public class RequestProductController {
    private final RequestProductService requestProductService;

    @Autowired
    public RequestProductController(RequestProductService requestProductService) {
        this.requestProductService = requestProductService;
    }

    @GetMapping
    public ResponseEntity<List<RequestProduct>> getAllRequestProducts() {
        List<RequestProduct> requestProducts = requestProductService.findAll();
        return ResponseEntity.ok(requestProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestProduct> getRequestProductById(@PathVariable UUID id) {
        RequestProduct requestProduct = requestProductService.findById(id);
        if (requestProduct != null) {
            return ResponseEntity.ok(requestProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<RequestProduct>> getRequestProductByUserId(@PathVariable UUID userId) {
        List<RequestProduct> requestProducts = requestProductService.findByUserId(userId);
        return ResponseEntity.ok(requestProducts);
    }

    @PostMapping
    public ResponseEntity<RequestProduct> createRequestProduct(@RequestBody RequestProduct requestProduct) {
        RequestProduct createdRequestProduct = requestProductService.create(requestProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestProduct> updateRequestProduct(@PathVariable UUID id, @RequestBody RequestProduct updatedRequestProduct) {
        RequestProduct updatedProduct = requestProductService.update(id, updatedRequestProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequestProduct(@PathVariable UUID id) {
        requestProductService.delete(id);
        return ResponseEntity.noContent().build();
    }
}