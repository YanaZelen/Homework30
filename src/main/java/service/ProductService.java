package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Product;
import web.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
  private final ProductRepository repo;

  public List<Product> findAllProducts() {
    return repo.findAll();
  }

  public Product findProductById(Long id) {
    return repo.findById(id).get();
  }

  public void addProduct(Product product) {
    repo.save(product);
  }

  public void deleteProduct(Product product) {
    repo.delete(product);
  }
}
