package id.ac.ui.cs.adproa3.microservicerequestproduct.repository;

import id.ac.ui.cs.adproa3.microservicerequestproduct.model.RequestProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public interface RequestProductRepository extends JpaRepository<RequestProduct, UUID> {

}
