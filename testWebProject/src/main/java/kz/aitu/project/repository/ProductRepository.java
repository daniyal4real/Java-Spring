package kz.aitu.project.repository;

import kz.aitu.project.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product>findAll();

    List<Product> findById(long id);

    @Query(value="SELECT * FROM products WHERE category_id = ?", nativeQuery = true)
    List<Product>findByCategoryId(long categoryId);

}
