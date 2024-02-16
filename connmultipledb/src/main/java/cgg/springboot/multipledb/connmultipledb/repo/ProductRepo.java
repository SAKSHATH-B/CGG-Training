package cgg.springboot.multipledb.connmultipledb.repo;

import cgg.springboot.multipledb.connmultipledb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
  Product findByName(String title);
}
