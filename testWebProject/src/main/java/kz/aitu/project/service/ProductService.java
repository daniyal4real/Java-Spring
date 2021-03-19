package kz.aitu.project.service;

import kz.aitu.project.entity.Product;
import kz.aitu.project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> getById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getByCategoryId(long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product updateById(Product product, long id) {
        return productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }


}
