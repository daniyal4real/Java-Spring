package kz.aitu.project.repository;

import kz.aitu.project.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category>findAll();

    List<Category>findById(long id);
}
