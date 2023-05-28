package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Product;
import web.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping(value = "/findAllProducts")
  public ResponseEntity<String> findAllProducts() {
    List<Product> all = productService.findAllProducts();
    return ResponseEntity.ok(all.toString());
  }

  @PostMapping(value = "/product/add")
  public String addProduct(Product product) {
    productService.addProduct(product);
    return "redirect:/product";
  }

}