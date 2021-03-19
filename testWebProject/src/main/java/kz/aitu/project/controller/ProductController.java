package kz.aitu.project.controller;

import kz.aitu.project.entity.Product;
import kz.aitu.project.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable long productId){
        return ResponseEntity.ok(productService.getById(productId));
    }

    @GetMapping("/api/products/categories/{categoryId}")
    public ResponseEntity<?> getByCategoryId(@PathVariable long categoryId){
        return ResponseEntity.ok(productService.getByCategoryId(categoryId));
    }

    @PostMapping("/api/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/api/products/{productId}")
    public ResponseEntity<?> updateProductById(@RequestBody Product product, @PathVariable long productId){
        return ResponseEntity.ok(productService.updateById(product, productId));
    }

    @DeleteMapping("/api/products/{productId}")
    public void deleteProductById(@PathVariable long productId){
        productService.deleteById(productId);
    }
}
